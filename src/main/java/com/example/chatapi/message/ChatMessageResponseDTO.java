package com.example.chatapi.message;

public class ChatMessageResponseDTO {
    private Integer id;
    private String content;

    public ChatMessageResponseDTO(Integer id, String content){
        this.id = id;
        this.content = content;
    }
    public Integer getId(){return id;}
    public String getContent(){return content;}
}
