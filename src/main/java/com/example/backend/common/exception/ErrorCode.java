package com.example.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "C000", "Invalid Request Data [%s]"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "C001", "Not Found [%s]"),
    COUPON_NOT_FOUND(HttpStatus.NOT_FOUND, "C002", "Coupon Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C999", "Internal Server Error")
    ;

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}

