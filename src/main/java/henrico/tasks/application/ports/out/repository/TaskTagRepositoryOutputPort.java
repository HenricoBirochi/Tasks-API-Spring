package henrico.tasks.application.ports.out.repository;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskTag;

public interface TaskTagRepositoryOutputPort {

    TaskTag insert(TaskTag taskTag);
    TaskTag update(TaskTag taskTag);
    TaskTag findById(UUID taskTagId);
    List<TaskTag> findAll();
    void delete(UUID taskTagId);

}
