package henrico.tasks.adapters.in.controller.mapper;

import org.springframework.stereotype.Component;

import henrico.tasks.adapters.in.controller.dto.UserRequestDTO;
import henrico.tasks.application.core.domain.User;

@Component
public class UserDTOMapper {
    public User toUser(UserRequestDTO userRequestDTO) {
        return new User(
            userRequestDTO.getName(),
            userRequestDTO.getEmail(),
            userRequestDTO.getPassword()
        );
    }
}
