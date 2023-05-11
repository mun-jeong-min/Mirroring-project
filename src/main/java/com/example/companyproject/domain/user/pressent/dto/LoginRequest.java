package com.example.companyproject.domain.user.pressent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    private String password;

}
