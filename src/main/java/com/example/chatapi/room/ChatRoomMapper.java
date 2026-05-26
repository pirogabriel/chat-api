package com.example.chatapi.room;

public class ChatRoomMapper {
    public static ChatRoomResponseDTO toResponse(ChatRoom chatRoom){
        return new ChatRoomResponseDTO(chatRoom.getId(), chatRoom.getName());
    }
    public static ChatRoom toEntity(CreateRoomRequest request){
        return new ChatRoom(request.getName());
    }
}
