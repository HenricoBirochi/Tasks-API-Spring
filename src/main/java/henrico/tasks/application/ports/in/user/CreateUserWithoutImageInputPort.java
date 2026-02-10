package henrico.tasks.application.ports.in.user;

import henrico.tasks.application.core.domain.User;

public interface CreateUserWithoutImageInputPort {

    User createUser(User user);

}
