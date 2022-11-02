package com.example.backend.common.exception;


import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {

    public NotFoundException(Object... additional) {
        super(ErrorCode.NOT_FOUND, additional);
    }

}
