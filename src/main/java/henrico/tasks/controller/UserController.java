package henrico.tasks.controller;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import henrico.tasks.controller.dto.HttpResponseDTO;
import henrico.tasks.controller.dto.UserRequestDTO;
import henrico.tasks.controller.mapper.UserDTOMapper;
import henrico.tasks.core.domain.User;
import henrico.tasks.core.usecases.CreateUserWithImageUseCase;
import henrico.tasks.core.usecases.CreateUserWithoutImageUseCase;
import henrico.tasks.core.usecases.DeleteUserUseCase;
import henrico.tasks.core.usecases.FindUserByIdUseCase;
import jakarta.servlet.http.Part;


@RequestMapping("/user")
@RestController
public class UserController {

    private final FindUserByIdUseCase findUserByIdUseCase;
    private final CreateUserWithImageUseCase createUserWithImageUseCase;
    private final CreateUserWithoutImageUseCase createUserWithoutImageUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(
        FindUserByIdUseCase findUserByIdUseCase,
        CreateUserWithImageUseCase createUserWithImageUseCase,
        CreateUserWithoutImageUseCase createUserWithoutImageUseCase,
        DeleteUserUseCase deleteUserUseCase,
        UserDTOMapper userDTOMapper
    ) {
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.createUserWithImageUseCase = createUserWithImageUseCase;
        this.createUserWithoutImageUseCase = createUserWithoutImageUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.userDTOMapper = userDTOMapper;
    }

    @GetMapping("/")
    public ResponseEntity<User> getUser(@RequestParam UUID userId) {
        var user = findUserByIdUseCase.findUserById(userId);
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping(value = "/post/with-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> postUserWithImage(
        @RequestPart("user") UserRequestDTO userRequestDTO,
        @RequestPart("imageFile") Part imageFile
    ) {
        var user = userDTOMapper.toUser(userRequestDTO);
        var userCreated = createUserWithImageUseCase.createUser(user, imageFile);
        return ResponseEntity.status(201).body(userCreated);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<User> postUser(@RequestBody UserRequestDTO userRequestDTO) {
        var user = userDTOMapper.toUser(userRequestDTO);
        var userCreated = createUserWithoutImageUseCase.createUser(user);
        return ResponseEntity.status(201).body(userCreated);
    }

    @DeleteMapping()
    public ResponseEntity<HttpResponseDTO> deleteUser(@RequestParam("userId") UUID userId) {
        deleteUserUseCase.deleteUser(userId);
        var httpResponse = HttpResponseDTO
                                        .builder()
                                        .statusCode(201)
                                        .message("User deleted successfully")
                                        .build();
        return ResponseEntity.status(201).body(httpResponse);
    }
}
