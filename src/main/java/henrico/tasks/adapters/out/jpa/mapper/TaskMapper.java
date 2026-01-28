package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskDbContext;
import henrico.tasks.application.core.domain.Task;

public class TaskMapper {
    public static Task toTaskShallow(TaskDbContext taskDbContext) {
        return new Task(
                taskDbContext.getId(),
                taskDbContext.getTitle(),
                taskDbContext.getDescription(),
                taskDbContext.getCoins(),
                taskDbContext.getDeadline(),
                taskDbContext.getTaskStatus()
        );
    }

    public static Task toTaskDeep(TaskDbContext taskDbContext) {
        return new Task(
                taskDbContext.getId(),
                taskDbContext.getTitle(),
                taskDbContext.getDescription(),
                taskDbContext.getCoins(),
                taskDbContext.getDeadline(),
                taskDbContext.getTaskStatus(),
                TaskGroupMapper.toTaskGroup(taskDbContext.getTaskGroupDbContext())
        );
    }

    public static TaskDbContext toTaskDbContext(Task task) {
        return TaskDbContext
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
