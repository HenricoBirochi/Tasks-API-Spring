package henrico.tasks.application.services;

import henrico.tasks.core.domain.User;
import henrico.tasks.core.usecases.FindUserByIdUseCase;
import java.util.UUID;

public class FindUserByIdService implements FindUserByIdUseCase {

    @Override
    public User findUserById(UUID userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
