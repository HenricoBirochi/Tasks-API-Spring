package henrico.tasks.adapters.in.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.CreateUserWithoutImageInputPort;
import henrico.tasks.application.ports.in.FindUserByIdInputPort;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import henrico.tasks.adapters.in.controller.dto.UserRequestDTO;
import henrico.tasks.adapters.in.controller.mapper.UserDTOMapper;



@RequestMapping("/user")
@RestController
public class UserController {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final CreateUserWithoutImageInputPort createUserWithoutImageInputPort;

    private final UserDTOMapper userDTOMapper;

    public UserController(
        FindUserByIdInputPort findUserByIdInputPort,
        CreateUserWithoutImageInputPort createUserWithoutImageInputPort,
        UserDTOMapper userDTOMapper
    ) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.createUserWithoutImageInputPort = createUserWithoutImageInputPort;
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

        var userCreated = createUserWithoutImageInputPort.createUser(user);

        return ResponseEntity.status(201).body(userCreated);
    }

}
