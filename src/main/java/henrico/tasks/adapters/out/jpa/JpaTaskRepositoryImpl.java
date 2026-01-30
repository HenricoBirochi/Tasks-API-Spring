package henrico.tasks.adapters.out.jpa;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;
import henrico.tasks.adapters.out.jpa.mapper.TaskMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaTaskRepositoryImpl implements TaskRepository {

    @Autowired
    private JpaTaskRepository jpaTaskRepository;

    @Override
    public Task insert(Task task) {
        TaskEntity taskEntity = TaskMapper.toTaskDbContext(task);
        jpaTaskRepository.save(taskEntity);
        return task;
    }

    @Override
    public Task findById(UUID taskId) {
        TaskEntity taskEntity = jpaTaskRepository.findById(taskId).orElse(null);
        return TaskMapper.toTaskShallow(taskEntity);
    }

    @Override
    public List<Task> findAll(UUID taskGroupId) {
        var allTasks = jpaTaskRepository.findByTaskGroupId(taskGroupId);
        return allTasks
                .stream()
                .map(taskDbContext -> TaskMapper.toTaskDeep(taskDbContext))
                .toList();
    }

    @Override
    public void delete(UUID taskId) {
        jpaTaskRepository.deleteById(taskId);
    }
}
