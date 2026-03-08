package henrico.tasks.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import henrico.tasks.controller.dto.UserRequestDTO;
import henrico.tasks.controller.mapper.UserDTOMapper;
import henrico.tasks.core.domain.User;
import henrico.tasks.core.usecases.CreateUserWithImageUseCase;
import henrico.tasks.core.usecases.FindUserByIdUseCase;
import jakarta.servlet.http.Part;

@RequestMapping("/user")
@RestController
public class UserController {

    private final FindUserByIdUseCase findUserByIdUseCase;
    private final CreateUserWithImageUseCase createUserWithImageUsecase;

    private final UserDTOMapper userDTOMapper;

    public UserController(
        FindUserByIdUseCase findUserByIdUseCase,
        CreateUserWithImageUseCase createUserWithImageUsecase,
        UserDTOMapper userDTOMapper
    ) {
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.createUserWithImageUsecase = createUserWithImageUsecase;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping("/")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        var user = findUserByIdUseCase.findUserById(userId);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping(value = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> postUser(
        @RequestPart("user") UserRequestDTO userRequestDTO,
        @RequestPart("imageFile") Part imageFile
    ) {
        var user = userDTOMapper.toUser(userRequestDTO);
        var userCreated = createUserWithImageUsecase.createUser(user, imageFile);
        return ResponseEntity.status(201).body(userCreated);
    }
}
