package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import henrico.tasks.adapters.out.jpa.entity.UserEntity;
import henrico.tasks.application.core.domain.TaskGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class TaskGroupMapper {

    private TaskMapper taskMapper;

    public TaskGroupMapper(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @PersistenceContext
    private EntityManager em;

    public TaskGroup toTaskGroup(TaskGroupEntity taskGroupEntity) {
        return new TaskGroup(
                taskGroupEntity.getId(),
                taskGroupEntity.getName(),
                taskGroupEntity
                        .getTasks()
                        .stream()
                        .map(taskEntity -> taskMapper.toTask(taskEntity))
                        .toList(),
                taskGroupEntity.getUserEntity().getId()
        );
    }

    public TaskGroupEntity toTaskGroupEntity(TaskGroup taskGroup) {
        return TaskGroupEntity
                .builder()
                .id(taskGroup.getId())
                .name(taskGroup.getName())
                .userEntity(em.getReference(UserEntity.class, taskGroup.getUserId()))
                .build();
    }
}
