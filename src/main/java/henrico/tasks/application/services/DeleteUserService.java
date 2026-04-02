package henrico.tasks.application.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import henrico.tasks.adapters.repository.ImageRepositoryGateway;
import henrico.tasks.adapters.repository.UserRepositoryGateway;
import henrico.tasks.core.domain.Image;
import henrico.tasks.core.domain.User;
import henrico.tasks.core.exceptions.ImageProcessingException;
import henrico.tasks.core.usecases.DeleteUserUseCase;

public class DeleteUserService implements DeleteUserUseCase {
    private final UserRepositoryGateway userRepositoryGateway;
    private final ImageRepositoryGateway imageRepositoryGateway;

    public DeleteUserService(
        UserRepositoryGateway userRepositoryGateway,
        ImageRepositoryGateway imageRepositoryGateway
    ) {
        this.userRepositoryGateway = userRepositoryGateway;
        this.imageRepositoryGateway = imageRepositoryGateway;
    }

    @Override
    public void deleteUser(UUID userId) {
        try {
            deleteImageFile(userId);
            userRepositoryGateway.delete(userId);
        } catch (IOException exception) {
            throw new ImageProcessingException("Error when trying to process the user image");
        }
    }

    public void deleteImageFile(UUID userId) throws IOException {
        User user = userRepositoryGateway.findById(userId);
        Image image = imageRepositoryGateway.findById(user.getImage().getId());

        Path uploadDir = Path.of("./userImageUploads");
        String fileName = image.getId().toString().concat(image.getImageExtension());

        Path savedPath = uploadDir.resolve(fileName);

        Files.delete(savedPath);
    }
}
