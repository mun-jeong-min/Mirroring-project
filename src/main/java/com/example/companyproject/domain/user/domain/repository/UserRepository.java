package com.example.companyproject.domain.user.domain.repository;

import com.example.companyproject.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
