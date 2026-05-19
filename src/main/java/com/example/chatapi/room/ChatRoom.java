package com.example.chatapi.room;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date createdAt;

    public ChatRoom(){}

    public ChatRoom(String name, Date createdAt){
        this.name = name;
        this.createdAt = createdAt;
    }
    public Integer getId(){return id;}
    public String getName(){return name;}
    public Date getCreatedAt(){return createdAt;}

}
