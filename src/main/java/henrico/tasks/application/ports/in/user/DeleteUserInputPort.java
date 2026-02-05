package henrico.tasks.application.ports.in.user;

import java.util.UUID;

public interface DeleteUserInputPort {

    void deleteUser(UUID userId);

}
