package com.example.companyproject.global.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.example.companyproject.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocketIOService {

    public static final Map<String, SocketIOClient> connectMap = new ConcurrentHashMap<>();

    private final SocketIOServer socketIOServer;

    private final JwtTokenProvider jwtTokenProvider;

    private final ConnectListener connectListener = new ConnectListener() {
        @Override
        public void onConnect(SocketIOClient client) {
            String token = client.getHandshakeData().getHttpHeaders().get("token");
            String username = jwtTokenProvider.getTokenSubject(token);
            connectMap.put(username, client);
            client.set("username", username);
        }
    };
    private final DisconnectListener disconnectListener = new DisconnectListener() {
        @Override
        public void onDisconnect(SocketIOClient client) {
            String username = client.get("username");
            connectMap.remove(username);
            client.disconnect();
        }
    };

    @PostConstruct
    private void start() {
        socketIOServer.addConnectListener(connectListener);
        socketIOServer.addDisconnectListener(disconnectListener);
        socketIOServer.start();
    }

    @PreDestroy
    private void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
        }
    }
}