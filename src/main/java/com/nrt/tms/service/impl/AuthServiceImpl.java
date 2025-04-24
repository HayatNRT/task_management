package com.nrt.tms.service.impl;

import com.nrt.tms.dto.AuthRequest;
import com.nrt.tms.dto.AuthResponse;
import com.nrt.tms.dto.RegisterRequest;
import com.nrt.tms.entity.User;
import com.nrt.tms.repository.UserRepository;
import com.nrt.tms.service.AuthService;
import com.nrt.tms.service.JwtService;
import com.nrt.tms.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists.");
        }
        Role role = request.getRole().equalsIgnoreCase("ROLE_MEMBER") ? Role.MEMBER :
                request.getRole().equalsIgnoreCase("ROLE_MANAGER") ? Role.MANAGER :
                        request.getRole().equalsIgnoreCase("ROLE_TEAM_LEAD") ? Role.TEAM_LEAD :
                                null;


        User user = User.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName()).role(role).active(true).build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        String refresh = jwtService.generateRefreshToken(user);

        return new AuthResponse(token, refresh, user.getRole().name());
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        String token = jwtService.generateToken(user);
        String refresh = jwtService.generateRefreshToken(user);

        return new AuthResponse(token, refresh, user.getRole().name());
    }
}

