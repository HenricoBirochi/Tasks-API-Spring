package henrico.tasks.adapters.out.jpa;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import henrico.tasks.adapters.out.jpa.mapper.UserMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaUserRepository;
import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryOutputPort {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public JpaUserRepositoryAdapter(
        JpaUserRepository jpaUserRepository,
        UserMapper userMapper
    ) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User insert(User user) {
        var userEntity = userMapper.toUserEntity(user);
        jpaUserRepository.save(userEntity);
        return user;
    }

    @Override
    public User update(User user) {
        try {
            var userEntity = jpaUserRepository
                    .findById(user.getId()).orElseThrow(() -> new EntityNotFoundException());

            Field[] fields = User.class.getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);

                if(field.get(user) == null || field.get(user).equals("")) {
                    continue;
                }

                field.set(userEntity, user);
            }

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
                .map(userEntity -> userMapper.toUser(userEntity))
                .toList();
    }

    @Override
    public void delete(UUID userId) {
        jpaUserRepository.deleteById(userId);
    }

}
