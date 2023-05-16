package com.example.companyproject.domain.chat.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AllRoomResponse {
    private String roomCode;
    private String roomName;
}
