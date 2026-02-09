package henrico.tasks.application.core.usecase.user;

import java.util.UUID;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.user.FindUserByIdInputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    @Override
    public User findUserById(UUID userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
