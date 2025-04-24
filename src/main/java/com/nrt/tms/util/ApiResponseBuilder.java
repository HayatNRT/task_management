package com.nrt.tms.util;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiResponseBuilder {

    private final ResponseCodeResolver resolver;

    public <T> ResponseEntity<ApiResponse<T>> ok(String key, T data) {
        return ResponseEntity.ok(new ApiResponse<>(resolver.get(key), data, true));
    }

    public ResponseEntity<ApiResponse<String>> error(String key, Exception e, HttpStatus status) {
        return ResponseEntity.status(status).body(new ApiResponse<>(resolver.get(key), e.getMessage(), false));
    }

}
