package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.User;

public interface UpdateUserInputPort {

    User updateUser(User user);

}
