package com.example.companyproject.domain.user.facade;

import com.example.companyproject.domain.user.domain.User;
import com.example.companyproject.domain.user.domain.repository.UserRepository;
import com.example.companyproject.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByName(username);
    }

    public User getUserByName(String username) {
        return userRepository.findByName(username)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
