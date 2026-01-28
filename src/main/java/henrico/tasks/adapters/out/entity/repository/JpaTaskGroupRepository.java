package henrico.tasks.adapters.out.entity.repository;

import henrico.tasks.adapters.out.entity.TaskGroupDbContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskGroupRepository extends JpaRepository<TaskGroupDbContext, UUID> {
}
