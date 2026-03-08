package henrico.tasks.core.usecases;

import henrico.tasks.core.domain.User;

import java.util.UUID;

public interface FindUserByIdUseCase {

    User findUserById(UUID userId);

}
