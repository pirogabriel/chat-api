package com.example.chatapi.room;

public class ChatRoomResponseDTO {
    private Integer id;
    private String name;

    public ChatRoomResponseDTO(String name){
        this.id = id;
        this.name = name;
    }
    public Integer getId(){return id;}
    public String getName(){return name;}
}
