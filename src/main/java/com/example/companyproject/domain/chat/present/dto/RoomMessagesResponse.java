package com.example.companyproject.domain.chat.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RoomMessagesResponse {
    private String username;
    private String message;
    private LocalDateTime createdAt;
    private boolean isMine;
}
