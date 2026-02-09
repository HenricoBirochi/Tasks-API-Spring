package henrico.tasks.adapters.out.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import henrico.tasks.adapters.out.jpa.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, UUID> {
}
