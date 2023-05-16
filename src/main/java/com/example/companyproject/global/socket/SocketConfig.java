package com.example.companyproject.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ExceptionListener;
import com.example.companyproject.global.properties.NettyProperties;
import io.netty.channel.ChannelHandlerContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SocketConfig {

    private final NettyProperties nettyProperties;
    private final ExceptionListener exceptionListener = new ExceptionListener() {
        @Override
        public void onEventException(Exception e, List<Object> args, SocketIOClient client) {
            log.info("error : " + e.getMessage());
        }

        @Override
        public void onDisconnectException(Exception e, SocketIOClient client) {
            log.info("error : " + e.getMessage());
        }

        @Override
        public void onConnectException(Exception e, SocketIOClient client) {
            log.info("error : " + e.getMessage());
        }

        @Override
        public void onPingException(Exception e, SocketIOClient client) {
            log.info("error : " + e.getMessage());
        }

        @Override
        public boolean exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
            log.info("error : " + e.getMessage());

            return false;
        }
    };

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        com.corundumstudio.socketio.SocketConfig socketConfig = new com.corundumstudio.socketio.SocketConfig();
        config.setExceptionListener(exceptionListener);
        config.setSocketConfig(socketConfig);
        config.setHostname(nettyProperties.getHost());
        config.setPort(nettyProperties.getPort());
        config.setBossThreads(1);
        config.setWorkerThreads(100);
        return new SocketIOServer(config);
    }
}
