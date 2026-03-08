package henrico.tasks.core.usecases;

import henrico.tasks.core.domain.Task;

import java.util.List;

public interface FindAllTasksUseCase {

    List<Task> findAllTasks();

}
