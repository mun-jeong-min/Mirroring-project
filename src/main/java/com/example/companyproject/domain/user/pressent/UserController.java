package com.example.companyproject.domain.user.pressent;

import com.example.companyproject.domain.user.pressent.dto.LoginRequest;
import com.example.companyproject.domain.user.pressent.dto.SignupRequest;
import com.example.companyproject.domain.user.pressent.dto.TokenResponse;
import com.example.companyproject.domain.user.service.LoginService;
import com.example.companyproject.domain.user.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final SignUpService signUpService;
    private final LoginService loginService;

    @PostMapping
    public void signUp(@RequestBody SignupRequest request) {
        signUpService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

}
