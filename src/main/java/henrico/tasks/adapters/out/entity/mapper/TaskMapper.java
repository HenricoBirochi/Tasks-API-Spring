package henrico.tasks.adapters.out.entity.mapper;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.adapters.out.entity.TaskEntity;

public class TaskMapper {
    public static Task toDomain(TaskEntity taskDb) {
        return new Task(
                taskDb.getId(),
                taskDb.getTitle(),
                taskDb.getDescription(),
                taskDb.getDeadline(),
                taskDb.getTaskStatus());
    }

    public static TaskEntity toEntity(Task task) {
        return TaskEntity
                .builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .build();
    }
}
