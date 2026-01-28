package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskGroupDbContext;
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

    public static TaskGroupDbContext toTaskGroupDbContext(TaskGroup taskGroup) {
        return TaskGroupDbContext
                .builder()
                .id(taskGroup.getId())
                .name(taskGroup.getName())
                .tasks(taskGroup
                        .getTasks()
                        .stream()
                        .map(task -> TaskMapper.toTaskDbContext(task))
                        .toList())
                .user(UserMapper.toUserDbContext(taskGroup.getUser()))
                .build();
    }
}
