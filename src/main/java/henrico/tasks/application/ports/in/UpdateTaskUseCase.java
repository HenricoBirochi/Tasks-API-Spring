package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.Task;

public interface UpdateTaskUseCase {

    Task updateTask(Task task);

}
