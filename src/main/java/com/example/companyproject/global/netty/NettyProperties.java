package com.example.companyproject.global.netty;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "netty")
public class NettyProperties {

    private final Integer tcpPort;
    private final Integer bossCount;
    private final Integer workerCount;
    private final Boolean keepAlive;
    private final Integer backlog;
    
}
