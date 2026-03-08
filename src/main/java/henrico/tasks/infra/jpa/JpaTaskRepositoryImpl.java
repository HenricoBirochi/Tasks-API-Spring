package henrico.tasks.infra.jpa;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import henrico.tasks.infra.jpa.entity.TaskEntity;
import henrico.tasks.infra.jpa.mapper.TaskMapper;
import henrico.tasks.core.domain.Task;
import henrico.tasks.adapters.repository.TaskRepositoryGateway;
import jakarta.persistence.EntityNotFoundException;

@Repository
public class JpaTaskRepositoryImpl implements TaskRepositoryGateway {

    private final henrico.tasks.infra.jpa.repository.JpaTaskRepository jpaTaskRepository;
    private final TaskMapper taskMapper;

    public JpaTaskRepositoryImpl(
            henrico.tasks.infra.jpa.repository.JpaTaskRepository jpaTaskRepository,
            TaskMapper taskMapper
    ) {
        this.jpaTaskRepository = jpaTaskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task insert(Task task) {
        TaskEntity taskEntity = taskMapper.toTaskEntity(task);
        jpaTaskRepository.save(taskEntity);
        return taskMapper.toTask(taskEntity);
    }

    @Override
    public Task update(Task task) {
        try {
            var taskEntity = jpaTaskRepository
                .findById(task.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

            Field[] fields = Task.class.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
                if(field.get(task) == null || field.get(task).equals("")) {
                    continue;
                }
                field.set(taskEntity, task);
            }
            jpaTaskRepository.save(taskEntity);
            Task newTask = taskMapper.toTask(taskEntity);
            return newTask;
        }
        catch (EntityNotFoundException exception) {
            throw new RuntimeException("Task not found");
        }
        catch (IllegalAccessException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public Task findById(UUID taskId) {
        TaskEntity taskEntity = jpaTaskRepository.findById(taskId).orElse(null);
        return taskMapper.toTask(taskEntity);
    }

    @Override
    public List<Task> findAll() {
        var allTasks = jpaTaskRepository
                .findAll();
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
