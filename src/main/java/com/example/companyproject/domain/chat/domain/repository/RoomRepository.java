package com.example.companyproject.domain.chat.domain.repository;

import com.example.companyproject.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, String> {
    Optional<Room> findByRoomCode(String roomCode);
    List<Room> findAll();
}
