package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.Task;

import java.util.UUID;

public interface FindTaskByIdInputPort {

    Task findTaskById(UUID taskId);

}
