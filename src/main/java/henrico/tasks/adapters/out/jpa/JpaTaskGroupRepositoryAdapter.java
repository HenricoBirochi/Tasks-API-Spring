package henrico.tasks.adapters.out.jpa;

import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import henrico.tasks.adapters.out.jpa.mapper.TaskGroupMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaTaskGroupRepository;
import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.out.repository.TaskGroupRepositoryOutputPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaTaskGroupRepositoryAdapter implements TaskGroupRepositoryOutputPort {

    private JpaTaskGroupRepository jpaTaskGroupRepository;
    private TaskGroupMapper taskGroupMapper;

    public JpaTaskGroupRepositoryAdapter(
            JpaTaskGroupRepository jpaTaskGroupRepository,
            TaskGroupMapper taskGroupMapper
    ) {
        this.jpaTaskGroupRepository = jpaTaskGroupRepository;
        this.taskGroupMapper = taskGroupMapper;
    }

    @Override
    public TaskGroup insert(TaskGroup taskGroup) {
        TaskGroupEntity taskGroupEntity = taskGroupMapper.toTaskGroupEntity(taskGroup);
        jpaTaskGroupRepository.save(taskGroupEntity);
        return taskGroup;
    }

    @Override
    public TaskGroup findById(UUID taskGroupId) {
        var taskGroupEntity = jpaTaskGroupRepository.findById(taskGroupId).orElse(null);
        return taskGroupMapper.toTaskGroup(taskGroupEntity);
    }

    @Override
    public List<TaskGroup> findAll(UUID userId) {
        return jpaTaskGroupRepository
                .findAll()
                .stream()
                .filter(taskGroupDbContext -> taskGroupDbContext.getUserEntity().getId().equals(userId))
                .map(taskGroupDbContext -> taskGroupMapper.toTaskGroup(taskGroupDbContext))
                .toList();
    }

    @Override
    public void delete(UUID taskGroupId) {
        jpaTaskGroupRepository.deleteById(taskGroupId);
    }
}
