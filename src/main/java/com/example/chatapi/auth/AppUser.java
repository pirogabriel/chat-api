package com.example.chatapi.auth;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "app_users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String role;
    private Date createdAt;

    public AppUser(){}

    public AppUser(String username, String password, String role, Date createdAt){
        this.username = username;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public Integer getId(){return id;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public String getRole(){return role;}
    public Date getCreatedAt(){return createdAt;}

}
