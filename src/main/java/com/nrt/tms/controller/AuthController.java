package com.nrt.tms.controller;

import com.nrt.tms.dto.AuthRequest;
import com.nrt.tms.dto.AuthResponse;
import com.nrt.tms.dto.RegisterRequest;
import com.nrt.tms.service.AuthService;
import com.nrt.tms.util.ApiResponse;
import com.nrt.tms.util.ApiResponseBuilder;
import com.nrt.tms.util.ResponseKeys;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tms/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final ApiResponseBuilder response;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody @Valid RegisterRequest request) {
        return response.ok(ResponseKeys.RESOURCE_CREATED, authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@RequestBody @Valid AuthRequest request) {
        return response.ok(ResponseKeys.SUCCESS, authService.login(request));
    }
}

