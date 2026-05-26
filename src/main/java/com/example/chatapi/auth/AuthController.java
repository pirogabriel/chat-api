package com.example.chatapi.auth;

import com.example.chatapi.user.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request){
        return authService.login(request);
    }

    @Operation(summary = "Refresh token")
    @PostMapping("/refresh")
    public Map<String, String> refreshToken(@RequestBody Map<String, String> body){
        return authService.refreshToken(body);
    }

    @Operation(summary = "Register user")
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody RegisterRequest request){
        return authService.register(request);
    }

}
