package com.nrt.tms.exception;

import com.nrt.tms.util.ApiResponse;
import com.nrt.tms.util.ApiResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ApiResponseBuilder response;

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiResponse<String>> handleServiceException(ServiceException e) {
        log.error("{}", e.getMessage());
        return response.ok(e.getKey(), e.getMessage());
    }
}
