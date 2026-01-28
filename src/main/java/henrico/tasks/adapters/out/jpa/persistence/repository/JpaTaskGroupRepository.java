package henrico.tasks.adapters.out.jpa.persistence.repository;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskGroupDbContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskGroupRepository extends JpaRepository<TaskGroupDbContext, UUID> {
}
