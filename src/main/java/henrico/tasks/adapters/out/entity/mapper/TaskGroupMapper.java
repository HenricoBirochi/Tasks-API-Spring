package henrico.tasks.adapters.out.entity.mapper;

import henrico.tasks.adapters.out.entity.TaskGroupDbContext;
import henrico.tasks.application.core.domain.TaskGroup;

public class TaskGroupMapper {
    public static TaskGroup toTaskGroup(TaskGroupDbContext taskGroupDbContext) {
        return new TaskGroup(
                taskGroupDbContext.getId(),
                taskGroupDbContext.getName(),
                taskGroupDbContext
                        .getTasks()
                        .stream()
                        .map(taskDbContext -> TaskMapper.toTaskShallow(taskDbContext))
                        .toList(),
                UserMapper.toUserShallow(taskGroupDbContext.getUser())
        );
    }
}
