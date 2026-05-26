package com.example.chatapi.auth;

import com.example.chatapi.user.UserMapper;
import com.example.chatapi.user.UserResponseDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class AuthService {
    private final JwtService jwtService;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(JwtService jwtService, AppUserRepository appUserRepository, PasswordEncoder passwordEncoder){
        this.jwtService = jwtService;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Map<String, String> login(LoginRequest request){
        AppUser user = appUserRepository.findByUsername(request.getUsername()).orElseThrow(() -> new IllegalArgumentException("Invalid Credentials"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("Invalid Crendentials");
        }
        String accessToken = jwtService.generateToken(user.getUsername(), user.getRole());

        String refreshToken = jwtService.generateRefreshToken(user.getUsername());

        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
    }
    public Map<String, String> refreshToken(Map<String, String> body){
        String refreshToken = body.get("refreshToken");

        if(!jwtService.isTokenValid(refreshToken)){
            throw new IllegalArgumentException("Invalid refresh token");
        }

        String username = jwtService.extractUsername(refreshToken);

        AppUser user = appUserRepository.findByUsername(username).orElseThrow();

        String newAccessToken = jwtService.generateToken(user.getUsername(), user.getRole());

        return Map.of("accessToken", newAccessToken);
    }
    public UserResponseDTO register(RegisterRequest request){
        if(appUserRepository.findByUsername(request.getUsername()).isPresent()){
            throw new IllegalArgumentException("Username already exists");
        }
        AppUser user = new AppUser(request.getUsername(), passwordEncoder.encode(request.getPassword()), "ROLE_USER");

        AppUser savedUser = appUserRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }

}
