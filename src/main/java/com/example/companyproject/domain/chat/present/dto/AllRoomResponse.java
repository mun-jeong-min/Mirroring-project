package com.example.companyproject.domain.chat.present.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AllRoomResponse {
    private String roomCode;
    private String roomName;
}
