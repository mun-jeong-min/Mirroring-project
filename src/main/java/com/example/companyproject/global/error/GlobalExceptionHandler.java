package com.example.companyproject.global.error;

import com.example.companyproject.global.error.custom.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handlerException(CustomException e) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(e.getErrorCode().getStatus())
                        .message(e.getErrorCode().getMessage())
                        .build(),
                HttpStatus.valueOf(e.getErrorCode().getStatus())
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new ErrorResponse(400, e.getBindingResult().getAllErrors().get(0).getDefaultMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}