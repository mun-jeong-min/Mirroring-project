package com.example.companyproject.global.socket;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageDto {
    private String senderName;
    private String roomCode;
    private String message;
}