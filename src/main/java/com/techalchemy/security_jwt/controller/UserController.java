package com.techalchemy.security_jwt.controller;

import com.techalchemy.security_jwt.config.models.RegisterRequest;
import com.techalchemy.security_jwt.dto.UserDTO;
import com.techalchemy.security_jwt.entity.User;
import com.techalchemy.security_jwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello from API";
    }


    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO user = userService.findById(id);
        if(user.getId() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.findById(id));
    }

}
