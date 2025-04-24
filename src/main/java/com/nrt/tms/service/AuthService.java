package com.nrt.tms.service;

import com.nrt.tms.dto.AuthRequest;
import com.nrt.tms.dto.AuthResponse;
import com.nrt.tms.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
