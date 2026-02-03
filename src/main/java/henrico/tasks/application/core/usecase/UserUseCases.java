package henrico.tasks.application.core.usecase;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.UserInputPort;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;

public class UserUseCases implements UserInputPort {

    private final UserRepositoryOutputPort userRepositoryOutputPort;

    public UserUseCases(UserRepositoryOutputPort userRepositoryOutputPort) {
        this.userRepositoryOutputPort = userRepositoryOutputPort;
    }

    @Override
    public User insertUser(User user) {
        return userRepositoryOutputPort.insert(user);
    }

    @Override
    public User findUserById(UUID userId) {
        return userRepositoryOutputPort.findById(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositoryOutputPort.findAll();
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepositoryOutputPort.delete(userId);
    }
}
