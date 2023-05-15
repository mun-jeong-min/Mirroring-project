package com.example.companyproject.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.example.companyproject.global.properties.NettyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SocketConfig {

    private final NettyProperties nettyProperties;

    private SocketIOServer server;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();
        configuration.setHostname(nettyProperties.getHost());
        configuration.setPort(nettyProperties.getPort());
        server = new SocketIOServer(configuration);
        server.start();
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient client) {
                log.info("user id : " + client.getSessionId());
            }
        });

        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient client) {
                client.getNamespace().getAllClients().forEach(data -> {
                    log.info("user disconnect : " + data.getSessionId().toString());
                });
            }
        });

        return server;
    }

    @PreDestroy
    public void stopSocket() {
        this.server.stop();
    }
}
