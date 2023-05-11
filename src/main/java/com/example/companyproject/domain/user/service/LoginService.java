package com.example.companyproject.domain.user.service;

import com.example.companyproject.domain.user.domain.User;
import com.example.companyproject.domain.user.domain.repository.UserRepository;
import com.example.companyproject.domain.user.exception.UserNotFoundException;
import com.example.companyproject.domain.user.pressent.dto.LoginRequest;
import com.example.companyproject.domain.user.pressent.dto.TokenResponse;
import com.example.companyproject.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(readOnly = true)
    public TokenResponse login(LoginRequest request) {

        User user = userRepository.findByName(request.getName()).orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!user.getPassword().equals(request.getPassword())) {
            throw  UserNotFoundException.EXCEPTION;
        }

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(user.getName()))
                .build();
    }
}
