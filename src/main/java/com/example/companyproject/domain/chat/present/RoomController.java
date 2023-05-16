package com.example.companyproject.domain.chat.present;

import com.example.companyproject.domain.chat.present.dto.CreateRoomRequest;
import com.example.companyproject.domain.chat.present.dto.ListRoomResponse;
import com.example.companyproject.domain.chat.present.dto.RoomMessageListResponse;
import com.example.companyproject.domain.chat.service.AllRoomService;
import com.example.companyproject.domain.chat.service.CreateRoomService;
import com.example.companyproject.domain.chat.service.RoomMessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/room")
@RestController
public class RoomController {
    private final AllRoomService allRoomService;
    private final CreateRoomService createRoomService;
    private final RoomMessagesService roomMessagesService;

    @GetMapping
    public ListRoomResponse list() {
        return allRoomService.readAll();
    }

    @PostMapping
    public void create(@RequestBody CreateRoomRequest request) {
        createRoomService.make(request);
    }

    @GetMapping("/{code}")
    public RoomMessageListResponse messages(@PathVariable("code") String code) {
        return roomMessagesService.read(code);
    }
}
