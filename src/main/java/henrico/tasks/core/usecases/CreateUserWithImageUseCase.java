package henrico.tasks.core.usecases;

import henrico.tasks.core.domain.User;
import jakarta.servlet.http.Part;

public interface CreateUserWithImageUseCase {

    User createUser(User user, Part imageFile);

}
