package henrico.tasks.adapters.out.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import henrico.tasks.adapters.out.jpa.entity.ImageEntity;

public interface JpaImageRepository extends JpaRepository<ImageEntity, UUID> {
}
