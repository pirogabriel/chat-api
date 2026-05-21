package com.example.chatapi.user;

import jakarta.validation.constraints.NotBlank;

public class CreateUserRequest {
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;

    public String getUsername(){return username;}
    public String getPassword(){return password;}
}
