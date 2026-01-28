package henrico.tasks.adapters.out.entity.repository;

import henrico.tasks.adapters.out.entity.TaskDbContext;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTaskRepository extends JpaRepository<TaskDbContext, UUID> {
}
