package me.huynhducphu.producer.service;

import lombok.RequiredArgsConstructor;

import me.huynhducphu.producer.config.AuthConfiguration;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Admin 8/3/2025
 **/
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;


    @Override
    public String buildJwt(Long expirationRate) {
        Instant now = Instant.now();

        Instant validity = now.plus(expirationRate, ChronoUnit.SECONDS);

        JwsHeader jwsHeader = JwsHeader.with(AuthConfiguration.MAC_ALGORITHM).build();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(validity)
                .subject("HuynhDucPhu2502@gmail.com")
                .build();

        return jwtEncoder
                .encode(JwtEncoderParameters.from(jwsHeader, claims))
                .getTokenValue();
    }

    @Override
    public Jwt decodeJwt(String token) {
        return jwtDecoder.decode(token);
    }

}
