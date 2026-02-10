package henrico.tasks.application.core.usecase.user;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.core.domain.enums.UserRole;
import henrico.tasks.application.core.usecase.user.exceptions.EmailAlreadyRegisteredException;
import henrico.tasks.application.core.usecase.user.exceptions.PasswordNotValidException;
import henrico.tasks.application.ports.in.user.CreateUserWithoutImageInputPort;
import henrico.tasks.application.ports.out.repository.TaskRepositoryOutputPort;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;

public class CreateUserWithoutImageUseCase implements CreateUserWithoutImageInputPort {
    private final TaskRepositoryOutputPort taskRepositoryOutputPort;
    private final UserRepositoryOutputPort userRepositoryOutputPort;

    public CreateUserWithoutImageUseCase(
            TaskRepositoryOutputPort taskRepositoryOutputPort,
            UserRepositoryOutputPort userRepositoryOutputPort
    ) {
        this.taskRepositoryOutputPort = taskRepositoryOutputPort;
        this.userRepositoryOutputPort = userRepositoryOutputPort;
    }

    @Override
    public User createUser(User user) {
        try {
            verifyUserPassword(user.getPassword());
            verifyIfEmailIsAlreadyRegistered(user.getEmail());

            var newUser = setCoinsAndUserRoleOfUser(user);

            return userRepositoryOutputPort.insert(newUser);
        }
        catch(PasswordNotValidException | EmailAlreadyRegisteredException exception) {
            return new User();
        }
    }

    public User setCoinsAndUserRoleOfUser(User user) {
        user.setCoins(0);
        user.setUserRole(UserRole.NORMAL);

        return user;
    }

    public void verifyUserPassword(String password) {
        if(password.length() < 12) {
            throw new PasswordNotValidException("The password must contains at least 12 characters!");
        }
    }

    public void verifyIfEmailIsAlreadyRegistered(String email) {
        var users = userRepositoryOutputPort.findAll();

        for (User user : users) {
            if (user.getEmail().equals(email) || user.getEmail() == email) {
                throw new EmailAlreadyRegisteredException("This email is already registered!");
            }
        }
    }
}
