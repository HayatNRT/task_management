package com.nrt.tms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException {
    private final String key;
    private final String message;

    public ServiceException(String key, String message) {
        this.key = key;
        this.message = message;
    }
}
