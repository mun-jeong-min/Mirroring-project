package com.example.companyproject.domain.chat.domain.repository;

import com.example.companyproject.domain.chat.domain.Message;
import com.example.companyproject.domain.chat.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findMessagesByRoom(Room room);
}
