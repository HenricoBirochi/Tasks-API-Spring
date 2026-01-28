package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.persistence.entity.UserDbContext;
import henrico.tasks.application.core.domain.User;

public class UserMapper {
    public static User toUserShallow(UserDbContext userDbContext) {
        return new User(
                userDbContext.getId(),
                userDbContext.getName(),
                userDbContext.getCoins(),
                ImageMapper.toImage(userDbContext.getImage()),
                userDbContext.getUserRole()
        );
    }

    public static UserDbContext toUserDbContext(User user) {
        return UserDbContext
                .builder()
                .id(user.getId())
                .name(user.getName())
                .coins(user.getCoins())
                .userRole(user.getUserRole())
                .image(ImageMapper.toImageDbContext(user.getImage()))
                .build();
    }
}
