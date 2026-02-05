package henrico.tasks.application.ports.in.user;

import henrico.tasks.application.core.domain.User;

public interface CreateUserInputPort {

    User createUser(User user);

}
