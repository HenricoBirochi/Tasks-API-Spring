package henrico.tasks.adapters.in.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import henrico.tasks.adapters.in.controller.dto.UserRequestDTO;
import henrico.tasks.adapters.in.controller.mapper.UserDTOMapper;
import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.CreateUserWithImageInputPort;
import henrico.tasks.application.ports.in.FindUserByIdInputPort;
import jakarta.servlet.http.Part;

@RequestMapping("/user")
@RestController
public class UserController {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final CreateUserWithImageInputPort createUserWithImageInputPort;

    private final UserDTOMapper userDTOMapper;

    public UserController(
        FindUserByIdInputPort findUserByIdInputPort,
        CreateUserWithImageInputPort createUserWithImageInputPort,
        UserDTOMapper userDTOMapper
    ) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.createUserWithImageInputPort = createUserWithImageInputPort;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping("/")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        var user = findUserByIdInputPort.findUserById(userId);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping(value = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> postUser(
        @RequestPart("user") UserRequestDTO userRequestDTO,
        @RequestPart("imageFile") Part imageFile
    ) {
        var user = userDTOMapper.toUser(userRequestDTO);
        var userCreated = createUserWithImageInputPort.createUser(user, imageFile);
        return ResponseEntity.status(201).body(userCreated);
    }
}
