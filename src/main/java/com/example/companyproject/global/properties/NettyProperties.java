package com.example.companyproject.global.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "netty")
@ConstructorBinding
public class NettyProperties {

    private final String host;
    private final Integer port;

}
