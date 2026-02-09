package henrico.tasks.application.ports.in.user;

import henrico.tasks.application.core.domain.User;

import java.util.List;

public interface FindAllUsersInputPort {

    List<User> findAllUsers();

}
