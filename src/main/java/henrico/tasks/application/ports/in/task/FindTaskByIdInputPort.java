package henrico.tasks.application.ports.in.task;

import henrico.tasks.application.core.domain.Task;

import java.util.UUID;

public interface FindTaskByIdInputPort {

    Task findTaskById(UUID taskId);

}
