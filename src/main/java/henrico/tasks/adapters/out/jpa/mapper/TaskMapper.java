package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;
import henrico.tasks.application.core.domain.Task;

public class TaskMapper {
    public static Task toTaskShallow(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getCoins(),
                taskEntity.getDeadline(),
                taskEntity.getTaskStatus()
        );
    }

    public static Task toTaskDeep(TaskEntity taskEntity) {
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getCoins(),
                taskEntity.getDeadline(),
                taskEntity.getTaskStatus(),
                TaskGroupMapper.toTaskGroup(taskEntity.getTaskGroupEntity())
        );
    }

    public static TaskEntity toTaskDbContext(Task task) {
        return TaskEntity
                .builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .coins(task.getCoins())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .build();
    }
}
