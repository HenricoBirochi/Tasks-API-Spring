package henrico.tasks.adapters.out.jpa.mapper;

import org.springframework.stereotype.Component;

import henrico.tasks.adapters.out.jpa.entity.ImageEntity;
import henrico.tasks.adapters.out.jpa.entity.UserEntity;
import henrico.tasks.application.core.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class UserMapper {

    @PersistenceContext
    private EntityManager em;

    public User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCoins(),
                userEntity.getUserRole(),
                userEntity.getImageEntity().getId()
        );
    }

    public UserEntity toUserEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .imageEntity(em.getReference(ImageEntity.class, user.getImageId()))
                .build();
    }
}
