package com.example.companyproject.global.error.exception;

import com.example.companyproject.global.error.custom.CustomException;
import com.example.companyproject.global.error.custom.ErrorCode;

public class InValidJwtException extends CustomException {
    public static final InValidJwtException EXCEPTION =
            new InValidJwtException();

    public InValidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
