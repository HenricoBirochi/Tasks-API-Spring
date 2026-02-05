package henrico.tasks.adapters.in.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/")
    public ResponseEntity<UserResponse> getUser(@RequestParam UUID userId) {
        
    }

}
