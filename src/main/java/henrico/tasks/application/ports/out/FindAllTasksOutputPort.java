package henrico.tasks.application.ports.out;

import henrico.tasks.application.core.domain.Task;

import java.util.List;

public interface FindAllTasksOutputPort {

    List<Task> findAllTasks();

}
