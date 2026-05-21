package com.example.chatapi.room;

import jakarta.validation.constraints.NotBlank;

public class CreateRoomRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
}
