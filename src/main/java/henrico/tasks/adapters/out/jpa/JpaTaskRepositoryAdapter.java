package henrico.tasks.adapters.out.jpa;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;
import henrico.tasks.adapters.out.jpa.mapper.TaskMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.repository.TaskRepositoryOutputPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaTaskRepositoryAdapter implements TaskRepositoryOutputPort {

    private JpaTaskRepository jpaTaskRepository;
    private TaskMapper taskMapper;

    public JpaTaskRepositoryAdapter(
            JpaTaskRepository jpaTaskRepository,
            TaskMapper taskMapper
    ) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task insert(Task task) {
        TaskEntity taskEntity = taskMapper.toTaskEntity(task);
        jpaTaskRepository.save(taskEntity);
        return task;
    }

    @Override
    public Task findById(UUID taskId) {
        TaskEntity taskEntity = jpaTaskRepository.findById(taskId).orElse(null);
        return taskMapper.toTask(taskEntity);
    }

    @Override
    public List<Task> findAll(UUID taskGroupId) {
        var allTasks = jpaTaskRepository
                .findAll()
                .stream()
                .filter(taskEntity -> taskEntity.getTaskGroupEntity().getId().equals(taskGroupId))
                .toList();
        return allTasks
                .stream()
                .map(taskEntity -> taskMapper.toTask(taskEntity))
                .toList();
    }

    @Override
    public void delete(UUID taskId) {
        jpaTaskRepository.deleteById(taskId);
    }
}
