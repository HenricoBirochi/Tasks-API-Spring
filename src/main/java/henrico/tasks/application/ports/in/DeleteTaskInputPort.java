package henrico.tasks.application.ports.in;

import java.util.UUID;

public interface DeleteTaskInputPort {

    void deleteTask(UUID taskId);

}
