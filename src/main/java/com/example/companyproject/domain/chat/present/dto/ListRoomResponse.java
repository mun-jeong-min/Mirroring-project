package com.example.companyproject.domain.chat.present.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ListRoomResponse {
    private List<AllRoomResponse> roomList;
}
