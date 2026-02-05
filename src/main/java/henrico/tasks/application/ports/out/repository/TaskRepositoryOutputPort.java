package henrico.tasks.application.ports.out.repository;

import henrico.tasks.application.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepositoryOutputPort {

    Task insert(Task task);
    Task update(Task task);
    Task findById(UUID taskId);
    List<Task> findAll();
    void delete(UUID taskId);

}
