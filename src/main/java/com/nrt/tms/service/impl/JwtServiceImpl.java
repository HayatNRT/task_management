package com.nrt.tms.service.impl;

import com.nrt.tms.service.JwtService;
import com.nrt.tms.util.AppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    public Long JWT_TOKEN_VALIDITY = null;
//	 public static final Long JWT_TOKEN_VALIDITY= 2592000000L;

    private String secret = "jwtTokenKey";


    public String generateToken(UserDetails userDetails, AppConstants.Status status) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("roles", userDetails.getAuthorities());
        return doGenerateToken(claims, userDetails.getUsername(), status);
    }

    public String doGenerateToken(Map<String, Object> claims, String subject, AppConstants.Status status) {

        if (status != null && status.equals(AppConstants.Status.MOB)) {
            JWT_TOKEN_VALIDITY = 25920000000L;
        } else if (status != null && status.equals(AppConstants.Status.WEB)) {
            JWT_TOKEN_VALIDITY = 43200000L;
        } else {
            JWT_TOKEN_VALIDITY = 43200000L;
        }
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    //fetch token's username
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    //fetch token's expiration
    public Date getExpirationDateFromToken(String token) {
        Date d = getClaimFromToken(token, Claims::getExpiration);
        return d;

    }


    //validation
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {

        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        Date curr = new Date();
        Boolean expi = expiration.before(curr);
        return expi;
    }


    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
