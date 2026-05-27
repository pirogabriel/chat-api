package com.example.chatapi.message;

import com.example.chatapi.auth.AppUser;
import com.example.chatapi.auth.AppUserRepository;
import com.example.chatapi.room.ChatRoom;
import com.example.chatapi.room.ChatRoomRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final AppUserRepository appUserRepository;

    public ChatMessageService (ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository, AppUserRepository appUserRepository){
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
        this.appUserRepository = appUserRepository;
    }

    public ChatMessageResponseDTO sendMessage(Integer roomId, SendMessageRequest request, String username){
        ChatRoom room = chatRoomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        AppUser sender = appUserRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        ChatMessage message = new ChatMessage(request.getContent(), sender, room);
        ChatMessage savedMessage = chatMessageRepository.save(message);
        return ChatMessageMapper.toResponse(savedMessage);
    }

    public List<ChatMessageResponseDTO> getMessageByRoom(Integer roomId){
        ChatRoom room = chatRoomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return chatMessageRepository.findByRoom(room).stream().map(ChatMessageMapper::toResponse).toList();
    }
}
