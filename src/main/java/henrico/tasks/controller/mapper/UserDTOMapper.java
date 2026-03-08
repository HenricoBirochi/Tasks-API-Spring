package henrico.tasks.controller.mapper;

import org.springframework.stereotype.Component;

import henrico.tasks.controller.dto.UserRequestDTO;
import henrico.tasks.core.domain.User;

@Component
public class UserDTOMapper {
    public User toUser(UserRequestDTO userRequestDTO) {
        return new User(
            userRequestDTO.getUserName(),
            userRequestDTO.getName(),
            userRequestDTO.getEmail(),
            userRequestDTO.getPassword()
        );
    }
}
