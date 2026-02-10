package henrico.tasks.application.ports.in;

import java.util.UUID;

public interface DeleteUserInputPort {

    void deleteUser(UUID userId);

}
