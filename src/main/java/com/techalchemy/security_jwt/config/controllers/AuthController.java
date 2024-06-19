package com.techalchemy.security_jwt.config.controllers;

import com.techalchemy.security_jwt.config.models.AuthRequest;
import com.techalchemy.security_jwt.config.models.AuthResponse;
import com.techalchemy.security_jwt.config.models.RegisterRequest;
import com.techalchemy.security_jwt.config.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
