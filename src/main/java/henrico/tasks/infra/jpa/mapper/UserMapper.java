package henrico.tasks.infra.jpa.mapper;

import org.springframework.stereotype.Component;

import henrico.tasks.infra.jpa.entity.ImageEntity;
import henrico.tasks.infra.jpa.entity.UserEntity;
import henrico.tasks.core.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class UserMapper {

    @PersistenceContext
    private EntityManager em;

    public User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getUserName(),
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
                userEntity.getUserName(),
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
                .userName(user.getUserName())
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
                .userName(user.getUserName())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .build();
    }
}
