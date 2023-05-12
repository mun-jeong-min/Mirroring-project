package com.example.companyproject.domain.user.exception;

import com.example.companyproject.global.error.custom.CustomException;
import com.example.companyproject.global.error.custom.ErrorCode;

public class UserExistException extends CustomException {
    public static final UserExistException EXCEPTION =
            new UserExistException();

    public UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}
