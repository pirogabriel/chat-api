package com.example.chatapi.user;

import jakarta.validation.constraints.NotBlank;

public class UpdateUserRequest {
    @NotBlank(message = "Username cannot be empty")
    private String username;

    public String getUsername(){return username;}
}
