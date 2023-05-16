package com.example.companyproject.domain.chat.domain;

import com.example.companyproject.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_room")
@Entity
public class Room {

    @Id
    private String roomCode;

    @Column
    private String roomName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
