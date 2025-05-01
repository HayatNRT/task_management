package com.nrt.tms.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String accessToken;
    private String role;
    private Map<String, Object> data = new HashMap<>();

    public AuthResponse(String token, String userFullName, String userid) {
        this.accessToken = token;
        this.data.put("userFullName", userFullName);
        this.data.put("userid", userid);
    }
}

