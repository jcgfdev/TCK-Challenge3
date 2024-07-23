package co.com.jcgfdev.challenge3.controller;

import co.com.jcgfdev.challenge3.model.User;
import co.com.jcgfdev.challenge3.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
}
