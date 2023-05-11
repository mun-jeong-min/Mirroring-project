package com.example.companyproject.global.error.exception;

import com.example.companyproject.global.error.custom.CustomException;
import com.example.companyproject.global.error.custom.ErrorCode;

public class JwtExpiredException extends CustomException {
    public static final JwtExpiredException EXCEPTION =
            new JwtExpiredException();

    public JwtExpiredException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
