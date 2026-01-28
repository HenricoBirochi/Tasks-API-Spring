package henrico.tasks.application.ports.out;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.Task;

public interface FindAllTasksFromTaskGroupOutputPort {

    List<Task> findAllTasks(UUID taskGroupId);

}
