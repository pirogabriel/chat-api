package com.example.chatapi.websocket;

import com.example.chatapi.message.ChatMessageResponseDTO;
import com.example.chatapi.message.ChatMessageService;
import com.example.chatapi.message.SendMessageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatWebSocketController {
    private final ChatMessageService chatMessageService;

    public ChatWebSocketController(ChatMessageService chatMessageService){
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/rooms/{roomId}/send")
    @SendTo("/topic/rooms/{roomId}")
    public ChatMessageResponseDTO sendMessage(@DestinationVariable Integer roomId, SendMessageRequest request, Principal principal){
        return chatMessageService.sendMessage(roomId, request, principal.getName());
    }
}
