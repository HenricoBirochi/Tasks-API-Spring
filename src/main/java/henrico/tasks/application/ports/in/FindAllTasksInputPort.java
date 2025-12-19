package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.Task;

import java.util.List;

public interface FindAllTasksInputPort {

    List<Task> findAllTasks();

}
