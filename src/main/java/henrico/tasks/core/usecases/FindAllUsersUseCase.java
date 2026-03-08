package henrico.tasks.core.usecases;

import henrico.tasks.core.domain.User;

import java.util.List;

public interface FindAllUsersUseCase {

    List<User> findAllUsers();

}
