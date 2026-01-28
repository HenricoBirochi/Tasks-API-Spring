package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import henrico.tasks.application.core.domain.TaskGroup;

public class TaskGroupMapper {
    public static TaskGroup toTaskGroup(TaskGroupEntity taskGroupEntity) {
        return new TaskGroup(
                taskGroupEntity.getId(),
                taskGroupEntity.getName(),
                taskGroupEntity
                        .getTasks()
                        .stream()
                        .map(taskDbContext -> TaskMapper.toTaskShallow(taskDbContext))
                        .toList(),
                UserMapper.toUserShallow(taskGroupEntity.getUser())
        );
    }

    public static TaskGroupEntity toTaskGroupDbContext(TaskGroup taskGroup) {
        return TaskGroupEntity
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
