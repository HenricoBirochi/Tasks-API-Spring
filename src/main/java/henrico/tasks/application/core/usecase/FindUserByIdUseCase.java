package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.FindUserByIdInputPort;
import java.util.UUID;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    @Override
    public User findUserById(UUID userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
