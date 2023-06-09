package com.example.companyproject.domain.chat.service;

import com.example.companyproject.domain.chat.domain.Room;
import com.example.companyproject.domain.chat.domain.repository.MessageRepository;
import com.example.companyproject.domain.chat.facade.RoomFacade;
import com.example.companyproject.domain.chat.present.dto.RoomMessageListResponse;
import com.example.companyproject.domain.chat.present.dto.RoomMessagesResponse;
import com.example.companyproject.domain.user.domain.User;
import com.example.companyproject.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoomMessagesService {
    private final MessageRepository messageRepository;
    private final RoomFacade roomFacade;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public RoomMessageListResponse read(String roomCode) {

        Room room = roomFacade.getRoomById(roomCode);
        User user = userFacade.getCurrentUser();

        return RoomMessageListResponse.builder()
                .messages( messageRepository.findMessagesByRoom(room).stream().map(
                        message -> RoomMessagesResponse.builder()
                                .username(message.getUser().getName())
                                .message(message.getMessage())
                                .createdAt(message.getCreatedAt())
                                .isMine(user.equals(message.getUser()))
                                .build()
                ).collect(Collectors.toList()))
                .build();
    }
}
