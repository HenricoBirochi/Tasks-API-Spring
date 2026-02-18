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
                ImageMapper.toImage(userEntity.getImage())
        );
    }

    public User toUserWithoutImageId(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCoins(),
                userEntity.getUserRole()
        );
    }

    public UserEntity toUserEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .image(em.getReference(ImageEntity.class, user.getImage().getId()))
                .build();
    }

    public UserEntity toUserEntityWithoutImageReference(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .build();
    }
}
