package com.example.chatapi.user;

import com.example.chatapi.auth.AppUser;

public class UserMapper {
    public static UserResponseDTO toResponse(AppUser user){
        return new UserResponseDTO(user.getId(), user.getUsername(), user.getRole());
    }
}
