package henrico.tasks.application.ports.in.task;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.Task;

public interface FindAllTasksFromTaskGroupInputPort {

    List<Task> findAllTasks(UUID taskGroupId);

}
