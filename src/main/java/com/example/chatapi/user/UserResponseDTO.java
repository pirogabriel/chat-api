package com.example.chatapi.user;


import java.util.Date;

public class UserResponseDTO {
    private Integer id;
    private String username;
    private String role;

    public UserResponseDTO (Integer id, String username, String role){
        this.id = id;
        this.username = username;
        this.role = role;
    }
    public Integer getId(){return id;}
    public String getUsername(){return username;}
    public String getCreatedAt(){return role;}

}
