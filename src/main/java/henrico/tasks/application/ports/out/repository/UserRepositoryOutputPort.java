package henrico.tasks.application.ports.out.repository;

import henrico.tasks.application.core.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryOutputPort {

    User insert(User user);
    User findById(UUID userId);
    List<User> findAll();
    void delete(UUID userId);

}
