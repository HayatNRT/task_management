package com.nrt.tms.service.impl;

import com.nrt.tms.config.CustomUserDetail;
import com.nrt.tms.dto.AuthRequest;
import com.nrt.tms.dto.AuthResponse;
import com.nrt.tms.repository.ApplicationUserRepository;
import com.nrt.tms.service.AuthService;
import com.nrt.tms.service.JwtService;
import com.nrt.tms.util.AppConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ApplicationUserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();

        String jwtToken = jwtService.generateToken(userDetails, request.getStatus().equalsIgnoreCase("WEB") ? AppConstants.Status.WEB : AppConstants.Status.MOB);

        return new AuthResponse(jwtToken, userDetails.getUsername(), userDetails.getUser().getUid());
    }
}


