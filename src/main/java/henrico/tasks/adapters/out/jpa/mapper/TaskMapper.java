package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;
import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import henrico.tasks.application.core.domain.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    @PersistenceContext
    private EntityManager em;

    public Task toTask(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getCoins(),
                taskEntity.getDeadline(),
                taskEntity.getTaskStatus(),
                taskEntity.getTaskGroupEntity().getId()
        );
    }

    public TaskEntity toTaskEntity(Task task) {
        return TaskEntity
                .builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .coins(task.getCoins())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .taskGroupEntity(em.getReference(TaskGroupEntity.class, task.getTaskGroupId()))
                .build();
    }
}
