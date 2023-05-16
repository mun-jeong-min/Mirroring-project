package com.example.companyproject.domain.chat.exception;

import com.example.companyproject.global.error.custom.CustomException;
import com.example.companyproject.global.error.custom.ErrorCode;

public class RoomNotFoundException extends CustomException {

    public static final RoomNotFoundException EXCEPTION =
            new RoomNotFoundException();

    public RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }
}
