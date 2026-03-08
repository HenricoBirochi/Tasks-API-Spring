package henrico.tasks.adapters.repository;

import henrico.tasks.core.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryGateway {

    User insert(User user);
    User update(User user);
    User findById(UUID userId);
    List<User> findAll();
    void delete(UUID userId);

}
