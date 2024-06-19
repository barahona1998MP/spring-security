package com.techalchemy.security_jwt.config.services;

import com.techalchemy.security_jwt.config.models.AuthRequest;
import com.techalchemy.security_jwt.config.models.AuthResponse;
import com.techalchemy.security_jwt.config.models.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);

}
