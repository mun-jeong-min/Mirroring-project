package com.example.companyproject.global.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.example.companyproject.domain.chat.domain.Message;
import com.example.companyproject.domain.chat.domain.repository.MessageRepository;
import com.example.companyproject.domain.chat.facade.RoomFacade;
import com.example.companyproject.domain.user.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocketIOController {

    private final MessageRepository messageRepository;
    private final RoomFacade roomFacade;
    private final UserFacade userFacade;
    private final SocketIONamespace namespace;

    SocketIOController(SocketIOServer socketServer, MessageRepository messageRepository, RoomFacade roomFacade, UserFacade userFacade){

        namespace = socketServer.addNamespace("/chat");

        namespace.addEventListener("join", MessageDto.class, onJoin());
        namespace.addEventListener("leave", MessageDto.class, onLeave());
        namespace.addEventListener("messageSendToUser", MessageDto.class, onSendMessage);

        this.messageRepository = messageRepository;
        this.roomFacade = roomFacade;
        this.userFacade = userFacade;
    }

    private DataListener<MessageDto> onJoin() {
        return (client, data, ackSender) -> {
            client.joinRoom(data.getRoomCode());
            namespace.getRoomOperations(data.getRoomCode()).sendEvent("join", client.get("username"));
        };
    }

    private DataListener<MessageDto> onLeave() {
        return (client, data, ackSender) -> {
            client.leaveRoom(data.getRoomCode());
            namespace.getRoomOperations(data.getRoomCode()).sendEvent("leave", client.get("username"));
        };
    }

    public DataListener<MessageDto> onSendMessage = new DataListener<MessageDto>() {
        @Override
        public void onData(SocketIOClient client, MessageDto message, AckRequest acknowledge) throws Exception {
            namespace.getRoomOperations(message.getRoomCode()).sendEvent("message", client, message.getMessage());
            String username = client.get("username");
            messageRepository.save(
                    Message.builder()
                            .user(userFacade.getUserByName(username))
                            .message(message.getMessage())
                            .room(roomFacade.getRoomById(message.getRoomCode()))
                            .build()
            );
        }
    };
}