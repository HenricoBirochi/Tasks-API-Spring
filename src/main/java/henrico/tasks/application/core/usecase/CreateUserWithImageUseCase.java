package henrico.tasks.application.core.usecase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import henrico.tasks.application.core.domain.Image;
import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.core.domain.enums.UserRole;
import henrico.tasks.application.core.usecase.exceptions.EmailAlreadyRegisteredException;
import henrico.tasks.application.core.usecase.exceptions.ImageContentTypeNotValidException;
import henrico.tasks.application.core.usecase.exceptions.ImageProcessingException;
import henrico.tasks.application.core.usecase.exceptions.PasswordNotValidException;
import henrico.tasks.application.core.usecase.exceptions.UserNameAlreadyRegisteredException;
import henrico.tasks.application.ports.in.CreateUserWithImageInputPort;
import henrico.tasks.application.ports.out.repository.ImageRepositoryOutputPort;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;
import jakarta.servlet.http.Part;

public class CreateUserWithImageUseCase implements CreateUserWithImageInputPort {
    private static final Set<String> availableContentTypes = Set.of(
            "image/png",
            "image/jpg",
            "image/jpeg"
    );

    private final ImageRepositoryOutputPort imageRepositoryOutputPort;
    private final UserRepositoryOutputPort userRepositoryOutputPort;

    public CreateUserWithImageUseCase(
        ImageRepositoryOutputPort imageRepositoryOutputPort,
        UserRepositoryOutputPort userRepositoryOutputPort
    ) {
        this.imageRepositoryOutputPort = imageRepositoryOutputPort;
        this.userRepositoryOutputPort = userRepositoryOutputPort;
    }

    @Override
    public User createUser(User user, Part imageFile) {
        try {
            isUserPasswordValid(user.getPassword());
            isEmailOrUserNameAlreadyRegistered(user.getEmail(), user.getUserName());
            String contentType = verifyAndGetImageContentType(imageFile);
            var newUser = createImage(user, imageFile, contentType);
            return setFieldsAndCreateUser(newUser);
        } catch (IOException exception) {
            throw new ImageProcessingException("Error when trying to process the user image");
        }
    }

    public User setFieldsAndCreateUser(User user) {
        user.setCoins(0);
        user.setUserRole(UserRole.NORMAL);
        return userRepositoryOutputPort.insert(user);
    }

    public User createImage(User user, Part imageFile, String contentType) throws IOException {
        Image image = new Image(
            Path.of(imageFile.getSubmittedFileName())
                    .getFileName()
                    .toString()
                    .replaceFirst(contentType, ""),
            contentType
        );
        Image imageDb = imageRepositoryOutputPort.insert(image);
        createImageInUploadFolder(imageDb, imageFile, contentType);
        user.setImage(imageDb);
        return user;
    }

    public void createImageInUploadFolder(Image imageDb, Part imageFile, String contentType) throws IOException {
        Path uploadDir = Path.of("./userImageUploads");
        Files.createDirectories(uploadDir);
        String finalFileName = imageDb.getId().toString().concat(contentType);
        Path savedPath = uploadDir.resolve(finalFileName);
        try(InputStream in = imageFile.getInputStream()) {
            Files.copy(in, savedPath);
        }
    }

    // Data validation methods
    public String verifyAndGetImageContentType(Part imageFile) {
        String realMimeContentType = imageFile.getContentType();
        if(!availableContentTypes.contains(realMimeContentType)) {
            throw new ImageContentTypeNotValidException("The image must be PNG, JPG or JPEG!", realMimeContentType);
        }
        return switch (realMimeContentType) {
            case "image/png" -> ".png";
            case "image/jpg" -> ".jpg";
            case "image/jpeg" -> ".jpeg";
            default -> throw new AssertionError();
        };
    }

    public void isUserPasswordValid(String password) {
        if(password.length() < 12) {
            throw new PasswordNotValidException("The password must contains at least 12 characters!", password);
        }
    }

    public void isEmailOrUserNameAlreadyRegistered(String email, String userName) {
        var users = userRepositoryOutputPort.findAll();
        for(User user : users) {
            if(user.getEmail().equals(email)) {
                throw new EmailAlreadyRegisteredException("This Email is already registered, try another email please!", email);
            }
            if(user.getUserName().equals(userName)) {
                throw new UserNameAlreadyRegisteredException("This User Name is already registered, try another user name please!", userName);
            }
        }
    }
}
