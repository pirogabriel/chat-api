package com.example.chatapi.room;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService){
        this.chatRoomService = chatRoomService;
    }
    @Operation(summary = "Create Room")
    @PostMapping("/rooms")
    public ChatRoomResponseDTO createRoom(@Valid @RequestBody CreateRoomRequest request){
        return chatRoomService.createRoom(request);
    }
    @Operation(summary = "Rooms")
    @GetMapping("/rooms")
    public List<ChatRoomResponseDTO> getRooms(){
        return chatRoomService.getAllRooms();
    }
    @Operation(summary = "Find room by Id")
    @GetMapping("/rooms/{roomId}")
    public ChatRoomResponseDTO getRoomById(@PathVariable Integer roomId){
        return  chatRoomService.getRoomByIdDTO(roomId);
    }

}
