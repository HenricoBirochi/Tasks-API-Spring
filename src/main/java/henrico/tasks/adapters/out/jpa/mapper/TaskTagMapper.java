package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.TaskTagEntity;
import henrico.tasks.adapters.out.jpa.entity.UserEntity;
import henrico.tasks.application.core.domain.TaskTag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class TaskTagMapper {

    @PersistenceContext
    private EntityManager em;

    public TaskTag toTaskTag(TaskTagEntity taskTagEntity) {
        return new TaskTag(
                taskTagEntity.getId(),
                taskTagEntity.getName(),
                taskTagEntity.getUserEntity().getId()
        );
    }

    public TaskTagEntity toTaskTagEntity(TaskTag taskTag) {
        return TaskTagEntity
                .builder()
                .id(taskTag.getId())
                .name(taskTag.getName())
                .userEntity(em.getReference(UserEntity.class, taskTag.getUserId()))
                .build();
    }
}
