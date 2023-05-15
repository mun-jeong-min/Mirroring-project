package com.example.companyproject.domain.chat.domain.repository;

import com.example.companyproject.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, String> {
}
