package henrico.tasks.adapters.out.jpa;

import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import henrico.tasks.adapters.out.jpa.mapper.TaskGroupMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaTaskGroupRepository;
import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.out.repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TaskGroupRepositoryImpl implements TaskGroupRepository {

    @Autowired
    private JpaTaskGroupRepository jpaTaskGroupRepository;

    @Override
    public TaskGroup insert(TaskGroup taskGroup) {
        TaskGroupEntity taskGroupEntity = TaskGroupMapper.toTaskGroupDbContext(taskGroup);
        jpaTaskGroupRepository.save(taskGroupEntity);
        return taskGroup;
    }

    @Override
    public TaskGroup findById(UUID taskGroupId) {
        var taskGroupEntity = jpaTaskGroupRepository.findById(taskGroupId).orElse(null);
        return TaskGroupMapper.toTaskGroup(taskGroupEntity);
    }

    @Override
    public List<TaskGroup> findAll(UUID userId) {
        return jpaTaskGroupRepository
                .findAll()
                .stream()
                .filter(taskGroupDbContext -> taskGroupDbContext.getUser().getId().equals(userId))
                .map(taskGroupDbContext -> TaskGroupMapper.toTaskGroup(taskGroupDbContext))
                .toList();
    }

    @Override
    public void delete(UUID taskGroupId) {
        jpaTaskGroupRepository.deleteById(taskGroupId);
    }
}
