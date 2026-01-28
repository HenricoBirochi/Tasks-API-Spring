package henrico.tasks.adapters.out.jpa.repository;

import henrico.tasks.adapters.out.jpa.entity.TaskGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskGroupRepository extends JpaRepository<TaskGroupEntity, UUID> {
}
