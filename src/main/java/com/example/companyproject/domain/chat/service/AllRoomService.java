package com.example.companyproject.domain.chat.service;

import com.example.companyproject.domain.chat.domain.repository.RoomRepository;
import com.example.companyproject.domain.chat.present.dto.AllRoomResponse;
import com.example.companyproject.domain.chat.present.dto.ListRoomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AllRoomService {
    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public ListRoomResponse readAll() {

        return ListRoomResponse.builder()
                .roomList(
                        roomRepository.findAll().stream().map(
                        room -> AllRoomResponse.builder()
                                .roomName(room.getRoomName())
                                .roomCode(room.getRoomCode())
                                .build()
                ).collect(Collectors.toList()))
                .build();

    }
}
