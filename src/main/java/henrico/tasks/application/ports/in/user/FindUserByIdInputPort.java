package henrico.tasks.application.ports.in.user;

import henrico.tasks.application.core.domain.User;

import java.util.UUID;

public interface FindUserByIdInputPort {

    User findUserById(UUID userId);

}
