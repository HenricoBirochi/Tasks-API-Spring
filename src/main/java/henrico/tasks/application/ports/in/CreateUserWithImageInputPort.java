package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.User;
import jakarta.servlet.http.Part;

public interface CreateUserWithImageInputPort {

    User createUser(User user, Part imageFile);

}
