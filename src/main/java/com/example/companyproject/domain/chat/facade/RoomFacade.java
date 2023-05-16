package com.example.companyproject.domain.chat.facade;

import com.example.companyproject.domain.chat.domain.Room;
import com.example.companyproject.domain.chat.domain.repository.RoomRepository;
import com.example.companyproject.domain.chat.exception.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoomFacade {
    private final RoomRepository roomRepository;

    public Room getRoomById(String roomCode) {
        return roomRepository.findByRoomCode(roomCode)
                .orElseThrow(() -> RoomNotFoundException.EXCEPTION);
    }
}
