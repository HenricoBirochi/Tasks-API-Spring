package henrico.tasks.application.ports.out.repository;

import henrico.tasks.application.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {

    Task insert(Task task);
    Task findById(UUID taskId);
    List<Task> findAll(UUID taskGroupId);
    void delete(UUID taskId);

}
