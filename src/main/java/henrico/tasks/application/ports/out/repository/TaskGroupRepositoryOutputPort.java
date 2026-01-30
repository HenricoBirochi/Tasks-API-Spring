package henrico.tasks.application.ports.out.repository;

import henrico.tasks.application.core.domain.TaskGroup;

import java.util.List;
import java.util.UUID;

public interface TaskGroupRepositoryOutputPort {

    TaskGroup insert(TaskGroup taskGroup);
    TaskGroup findById(UUID taskGroupId);
    List<TaskGroup> findAll(UUID userId);
    void delete(UUID taskGroupId);

}
