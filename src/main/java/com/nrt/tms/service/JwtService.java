package com.nrt.tms.service;

import com.nrt.tms.util.AppConstants;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String getUsernameFromToken(String token);


    String generateToken(UserDetails userDetails, AppConstants.Status status);

    String doGenerateToken(Map<String, Object> claims, String subject, AppConstants.Status status);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

}
