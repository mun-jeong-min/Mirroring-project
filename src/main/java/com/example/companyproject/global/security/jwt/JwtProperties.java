package com.example.companyproject.global.security.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String jwtSecret;
    private final Long accessExp;
    private final String jwtHeader;
    private final String jwtPrefix;
}
