package com.example.chatapi.message;

import jakarta.validation.constraints.NotBlank;

public class SendMessageRequest {
    @NotBlank(message = "Message cannot be empty")
    private String content;

    public String getContent(){return content;}
    public void setContent(String content){this.content = content;}
}
