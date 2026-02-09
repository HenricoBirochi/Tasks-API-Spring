package henrico.tasks.adapters.in.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.user.CreateUserInputPort;
import henrico.tasks.application.ports.in.user.FindUserByIdInputPort;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import henrico.tasks.adapters.in.controller.dto.UserRequestDTO;
import henrico.tasks.adapters.in.controller.mapper.UserDTOMapper;



@RequestMapping("/user")
@RestController
public class UserController {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final CreateUserInputPort createUserInputPort;

    private final UserDTOMapper userDTOMapper;

    public UserController(
        FindUserByIdInputPort findUserByIdInputPort,
        CreateUserInputPort createUserInputPort,
        UserDTOMapper userDTOMapper
    ) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.createUserInputPort = createUserInputPort;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping("/")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        var user = findUserByIdInputPort.findUserById(userId);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/post")
    public ResponseEntity<User> postUser(@RequestBody UserRequestDTO userRequestDTO) {
        var user = userDTOMapper.toUser(userRequestDTO);

        var userCreated = createUserInputPort.createUser(user);

        return ResponseEntity.status(201).body(userCreated);
    }

}
