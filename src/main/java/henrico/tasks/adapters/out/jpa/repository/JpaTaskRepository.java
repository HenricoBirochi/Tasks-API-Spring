package henrico.tasks.adapters.out.jpa.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import henrico.tasks.adapters.out.jpa.entity.TaskEntity;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, UUID> {
}
