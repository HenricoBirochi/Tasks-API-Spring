package henrico.tasks.core.usecases;

import henrico.tasks.core.domain.Task;

import java.util.UUID;

public interface FindTaskByIdUseCase {

    Task findTaskById(UUID taskId);

}
