package com.example.companyproject.domain.user.exception;

import com.example.companyproject.global.error.custom.CustomException;
import com.example.companyproject.global.error.custom.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
