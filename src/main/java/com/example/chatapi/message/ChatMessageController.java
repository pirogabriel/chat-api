package com.example.chatapi.message;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/rooms/{roomId}/messages")
public class ChatMessageController {
    private final ChatMessageService chatMessageService;

    public ChatMessageController(ChatMessageService chatMessageService){
        this.chatMessageService = chatMessageService;
    }

    @GetMapping
    public List<ChatMessageResponseDTO> getMessageByRoom(@PathVariable Integer roomId){
        return chatMessageService.getMessageByRoom(roomId);
    }
    @PostMapping
    public ChatMessageResponseDTO sendMessage(@PathVariable Integer roomId, @Valid @RequestBody SendMessageRequest request, Principal principal){
        return chatMessageService.sendMessage(roomId, request, principal.getName());
    }
}
