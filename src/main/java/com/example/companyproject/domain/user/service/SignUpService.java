package com.example.companyproject.domain.user.service;

import com.example.companyproject.domain.user.domain.User;
import com.example.companyproject.domain.user.domain.repository.UserRepository;
import com.example.companyproject.domain.user.exception.UserExistException;
import com.example.companyproject.domain.user.pressent.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void signUp(SignupRequest request) {

        if(userRepository.findByName(request.getName()).isPresent()) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .password(request.getPassword())
                        .build()
        );
    }
}
