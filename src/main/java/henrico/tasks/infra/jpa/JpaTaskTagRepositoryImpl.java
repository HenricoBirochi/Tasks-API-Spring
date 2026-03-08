package henrico.tasks.infra.jpa;

import java.util.List;
import java.util.UUID;

import henrico.tasks.core.domain.TaskTag;
import henrico.tasks.adapters.repository.TaskTagRepositoryGateway;

public class JpaTaskTagRepositoryImpl implements TaskTagRepositoryGateway {

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
