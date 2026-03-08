package henrico.tasks.infra.jpa;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import henrico.tasks.infra.jpa.entity.UserEntity;
import henrico.tasks.infra.jpa.mapper.UserMapper;
import henrico.tasks.core.domain.User;
import henrico.tasks.adapters.repository.UserRepositoryGateway;
import jakarta.persistence.EntityNotFoundException;

@Repository
public class JpaUserRepositoryImpl implements UserRepositoryGateway {

    private final henrico.tasks.infra.jpa.repository.JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public JpaUserRepositoryImpl(
        henrico.tasks.infra.jpa.repository.JpaUserRepository jpaUserRepository,
        UserMapper userMapper
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User insert(User user) {
        UserEntity userEntity;
        if(user.getImage() == null) {
            userEntity = userMapper.toUserEntityWithoutImageReference(user);
            var userSaved = jpaUserRepository.save(userEntity);
            return userMapper.toUserWithoutImageId(userSaved);
        } else {
            userEntity = userMapper.toUserEntity(user);
            var userSaved = jpaUserRepository.save(userEntity);
            return userMapper.toUser(userSaved);
        }
    }

    @Override
    public User update(User user) {
        try {
            var userEntity = jpaUserRepository
                    .findById(user.getId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            Field[] fields = User.class.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);

                if(field.get(user) == null || field.get(user).equals("")) {
                    continue;
                }

                field.set(userEntity, user);
            }

            jpaUserRepository.save(userEntity);

            var newUser = userMapper.toUser(userEntity);

            return newUser;
        }
        catch (EntityNotFoundException exception) {
            throw new RuntimeException("User not found");
        }
        catch (IllegalAccessException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public User findById(UUID userId) {
        var userEntity = jpaUserRepository.findById(userId).orElse(null);
        return userMapper.toUser(userEntity);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository
                .findAll()
                .stream()
                .map(userEntity -> userMapper.toUserWithoutImageId(userEntity))
                .toList();
    }

    @Override
    public void delete(UUID userId) {
        jpaUserRepository.deleteById(userId);
    }

}
