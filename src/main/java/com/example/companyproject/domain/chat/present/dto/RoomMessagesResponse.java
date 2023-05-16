package com.example.companyproject.domain.chat.present.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomMessagesResponse {
    private String username;
    private String message;
}
