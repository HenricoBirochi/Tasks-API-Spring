package henrico.tasks.adapters.repository;

import henrico.tasks.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepositoryGateway {

    Task insert(Task task);
    Task update(Task task);
    Task findById(UUID taskId);
    List<Task> findAll();
    void delete(UUID taskId);

}
