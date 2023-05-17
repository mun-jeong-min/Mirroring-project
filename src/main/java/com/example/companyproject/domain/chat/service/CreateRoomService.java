package com.example.companyproject.domain.chat.service;

import com.example.companyproject.domain.chat.domain.Room;
import com.example.companyproject.domain.chat.domain.repository.RoomRepository;
import com.example.companyproject.domain.chat.present.dto.CreateRoomRequest;
import com.example.companyproject.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateRoomService {
    private final UserFacade userFacade;
    private final RoomRepository roomRepository;

    @Transactional
    public void make(CreateRoomRequest request) {
        roomRepository.save(
                Room.builder()
                        .roomCode(RandomString.make(5))
                        .roomName(request.getRoomName())
                        .user(userFacade.getCurrentUser())
                        .build()
        );
    }
}
