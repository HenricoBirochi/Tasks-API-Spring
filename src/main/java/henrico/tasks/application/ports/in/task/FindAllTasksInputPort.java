package henrico.tasks.application.ports.in.task;

import henrico.tasks.application.core.domain.Task;

import java.util.List;

public interface FindAllTasksInputPort {

    List<Task> findAllTasks();

}
