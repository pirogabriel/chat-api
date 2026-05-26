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
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public ChatRoom(){}

    public ChatRoom(String name){
        this.name = name;
    }
    @PrePersist
    public void prePersist(){
        this.createdAt = new Date();
    }

    public Integer getId(){return id;}
    public String getName(){return name;}
    public Date getCreatedAt(){return createdAt;}

}
