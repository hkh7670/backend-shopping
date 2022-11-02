package com.example.backend.common.exception;


import lombok.Getter;

@Getter
public class BadRequestException extends BaseException {

    public BadRequestException(Object... additional) {
        super(ErrorCode.INVALID_PARAMETER, additional);
    }

}
