package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserInputPort {

    User insertUser(User user);
    User updateUser(User user);
    User findUserById(UUID userId);
    List<User> findAllUsers();
    void deleteUser(UUID userId);

}
