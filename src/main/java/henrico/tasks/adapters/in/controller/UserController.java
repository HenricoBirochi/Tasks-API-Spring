package henrico.tasks.adapters.in.controller;

import java.util.UUID;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.UserInputPort;



@RestController
@RequestMapping("/user")
public class UserController {

    private final UserInputPort userInputPort;

    public UserController(UserInputPort userInputPort) {
        this.userInputPort = userInputPort;
    }

    @PostMapping("/")
    public ResponseEntity<User> postUser(@RequestParam User user) {
        userInputPort.insertUser(user);
        return ResponseEntity.status(201).body(user);
    }

    @GetMapping("/")
    public ResponseEntity<User> getUserById(@RequestParam UUID userId) {
        var user = userInputPort.findUserById(userId);
        return ResponseEntity.status(200).body(user);
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteUser(@RequestParam UUID userId) {
        userInputPort.deleteUser(userId);
        return ResponseEntity.status(204).build();
    }

    // Restricted route, only for admins
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        var allUsers = userInputPort.findAllUsers();
        return ResponseEntity.status(200).body(allUsers);
    }

}
