package henrico.tasks.adapters.repository;

import java.util.List;
import java.util.UUID;

import henrico.tasks.core.domain.TaskTag;

public interface TaskTagRepositoryGateway {

    TaskTag insert(TaskTag taskTag);
    TaskTag update(TaskTag taskTag);
    TaskTag findById(UUID taskTagId);
    List<TaskTag> findAll();
    void delete(UUID taskTagId);

}
