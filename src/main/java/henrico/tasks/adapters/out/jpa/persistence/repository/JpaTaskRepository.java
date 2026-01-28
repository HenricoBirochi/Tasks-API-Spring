package henrico.tasks.adapters.out.jpa.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskDbContext;

public interface JpaTaskRepository extends JpaRepository<TaskDbContext, UUID> {
    List<TaskDbContext> findByTaskGroupId(UUID taskGroupId);
}
