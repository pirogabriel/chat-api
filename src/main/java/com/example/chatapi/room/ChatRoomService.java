package com.example.chatapi.room;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
    }

    public ChatRoomResponseDTO createRoom(CreateRoomRequest request){
        ChatRoom room = new ChatRoom(request.getName());

        ChatRoom savedRoom = chatRoomRepository.save(room);

        return ChatRoomMapper.toResponse(savedRoom);
    }
    public List<ChatRoomResponseDTO> getAllRooms(){
        List<ChatRoom> rooms = chatRoomRepository.findAll();

        return rooms.stream().map(ChatRoomMapper::toResponse).toList();
    }
    public ChatRoomResponseDTO getRoomByIdDTO(Integer id){
        ChatRoom room = chatRoomRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Room not found"));
        return ChatRoomMapper.toResponse(room);
    }

}
