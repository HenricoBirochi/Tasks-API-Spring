package henrico.tasks.infra.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import henrico.tasks.adapters.repository.UserRepositoryGateway;
import henrico.tasks.core.domain.User;
import henrico.tasks.infra.jpa.entity.UserEntity;
import henrico.tasks.infra.jpa.mapper.UserMapper;
import henrico.tasks.infra.jpa.repository.JpaUserRepository;
import jakarta.persistence.EntityNotFoundException;

@Repository
public class JpaUserRepositoryUsing implements UserRepositoryGateway {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public JpaUserRepositoryUsing(
        JpaUserRepository jpaUserRepository,
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
        jpaUserRepository.findById(user.getId())
                         .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserEntity updatedUser = userMapper.toUserEntity(user);
        UserEntity updatedUserIndDb = jpaUserRepository.save(updatedUser);
        return userMapper.toUser(updatedUserIndDb);

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
