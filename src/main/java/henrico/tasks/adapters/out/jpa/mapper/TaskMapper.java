package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;
import henrico.tasks.adapters.out.jpa.entity.TaskTagEntity;
import henrico.tasks.adapters.out.jpa.entity.UserEntity;
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
                taskEntity.getTaskTagEntity().getId(),
                taskEntity.getUserEntity().getId()
        );
    }

    public TaskEntity toTaskEntity(Task task) {
        return TaskEntity
                .builder()
                .id(task.getId())
                .coins(task.getCoins())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .taskTagEntity(em.getReference(TaskTagEntity.class, task.getTaskTagId()))
                .userEntity(em.getReference(UserEntity.class, task.getUserId()))
                .build();
    }
}
