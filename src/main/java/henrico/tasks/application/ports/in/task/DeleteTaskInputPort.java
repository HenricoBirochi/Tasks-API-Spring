package henrico.tasks.application.ports.in.task;

import java.util.UUID;

public interface DeleteTaskInputPort {

    void deleteTask(UUID taskId);

}
