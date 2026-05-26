package com.example.chatapi.message;

public class ChatMessageMapper {
    public static ChatMessageResponseDTO toResponse(ChatMessage message){
        return new ChatMessageResponseDTO(message.getId(), message.getContent(), message.getSender().getUsername(), message.getRoom().getName(), message.getRoom().getId(), message.getCreatedAt());
    }
}
