package com.example.chatapi.message;

import java.util.Date;

public class ChatMessageResponseDTO {
    private Integer id;
    private String content;
    private String senderUsername;
    private String room;
    private Integer roomId;

    private Date createdAt;

    public ChatMessageResponseDTO(Integer id, String content, String senderUsername, String room, Integer roomId, Date createdAt){
        this.id = id;
        this.content = content;
        this.senderUsername = senderUsername;
        this.room = room;
        this.roomId = roomId;
        this.createdAt = createdAt;
    }
    public Integer getId(){return id;}
    public String getContent(){return content;}
    public String getSenderUsername(){return senderUsername;}
    public String getRoom(){return room;}
    public Integer getRoomId(){return roomId;}
    public Date getCreatedAt(){return createdAt;}
}
