package henrico.tasks.adapters.out.jpa;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskTag;
import henrico.tasks.application.ports.out.repository.TaskTagRepositoryOutputPort;

public class JpaTaskTagRepositoryAdapter implements TaskTagRepositoryOutputPort {

    @Override
    public TaskTag insert(TaskTag taskTag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TaskTag update(TaskTag taskTag) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TaskTag findById(UUID taskTagId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TaskTag> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(UUID taskTagId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
