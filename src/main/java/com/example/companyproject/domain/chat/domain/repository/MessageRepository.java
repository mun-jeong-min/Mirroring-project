package com.example.companyproject.domain.chat.domain.repository;

import com.example.companyproject.domain.chat.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
