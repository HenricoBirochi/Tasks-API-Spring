package henrico.tasks.application.services;

import henrico.tasks.adapters.repository.UserRepositoryGateway;
import henrico.tasks.core.domain.User;
import henrico.tasks.core.domain.enums.UserRole;
import henrico.tasks.core.exceptions.EmailAlreadyRegisteredException;
import henrico.tasks.core.exceptions.PasswordNotValidException;
import henrico.tasks.core.exceptions.UserNameAlreadyRegisteredException;
import henrico.tasks.core.usecases.CreateUserWithoutImageUseCase;

public class CreateUserWithoutImageService implements CreateUserWithoutImageUseCase {
    private final UserRepositoryGateway userRepositoryGateway;

    public CreateUserWithoutImageService(UserRepositoryGateway userRepositoryGateway) {
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public User createUser(User user) {
        isUserPasswordValid(user.getPassword());
        isEmailOrUserNameAlreadyRegistered(user.getEmail(), user.getUserName());
        return setFieldsAndCreateUser(user);
    }

    public User setFieldsAndCreateUser(User user) {
        user.setCoins(0);
        user.setUserRole(UserRole.NORMAL);
        return userRepositoryGateway.insert(user);
    }

    // Data validation methods
    public void isUserPasswordValid(String password) {
        if(password.length() < 12) {
            throw new PasswordNotValidException("The password must contains at least 12 characters!", password);
        }
    }

    public void isEmailOrUserNameAlreadyRegistered(String email, String userName) {
        var users = userRepositoryGateway.findAll();
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
