package com.example.chatapi.message;

import com.example.chatapi.auth.AppUser;
import com.example.chatapi.room.ChatRoom;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;
    @ManyToOne
    private AppUser sender;
    @ManyToOne
    private ChatRoom room;
    private Date createdAt;

    public ChatMessage(){}

    public ChatMessage(String content, AppUser sender, ChatRoom room, Date createdAt){
        this.content = content;
        this.sender = sender;
        this.room = room;
        this.createdAt = createdAt;
    }
    public String getContent(){return content;}
    public AppUser getSender(){return sender;}
    public ChatRoom getRoom(){return room;}
    public Date getCreatedAt(){return createdAt;}
}
