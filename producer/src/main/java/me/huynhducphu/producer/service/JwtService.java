package me.huynhducphu.producer.service;

import org.springframework.security.oauth2.jwt.Jwt;

/**
 * Admin 1/21/2026
 *
 **/
public interface JwtService {
    String buildJwt(Long expirationRate);

    Jwt decodeJwt(String token);
}
