package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskInputPort {

    Task insertTask(Task task);
    Task findTaskById(UUID taskId);
    List<Task> findAllTasks(UUID taskGroupId);
    void deleteTask(UUID taskId);

}
