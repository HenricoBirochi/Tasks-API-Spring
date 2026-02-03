package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.UserEntity;
import henrico.tasks.application.core.domain.User;

public class UserMapper {
    public User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getCoins(),
                ImageMapper.toImage(userEntity.getImage()),
                userEntity.getUserRole()
        );
    }

    public UserEntity toUserEntity(User user) {
        return UserEntity
                .builder()
                .id(user.getId())
                .name(user.getName())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .image(ImageMapper.toImageDbContext(user.getImage()))
                .build();
    }
}
