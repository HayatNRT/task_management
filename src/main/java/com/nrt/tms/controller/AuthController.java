package com.nrt.tms.controller;

import com.nrt.tms.dto.AuthRequest;
import com.nrt.tms.service.AuthService;
import com.nrt.tms.util.ApiResponseBuilder;
import com.nrt.tms.util.ResponseKeys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final ApiResponseBuilder response;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest request) {
        Map<String, Object> userMap = new HashMap<>();
        return response.ok(ResponseKeys.SUCCESS, authService.login(request));
    }
}

