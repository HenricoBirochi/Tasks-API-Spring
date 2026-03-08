package henrico.tasks.infra.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import henrico.tasks.infra.jpa.entity.TaskEntity;

public interface JpaTaskRepository extends JpaRepository<TaskEntity, UUID> {
}
