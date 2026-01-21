package me.huynhducphu.producer.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.huynhducphu.producer.service.JwtService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Admin 1/21/2026
 *
 **/
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class JwtController {

    JwtService jwtService;

    @PostMapping
    public ResponseEntity<@NonNull String> createJwt() {
        return ResponseEntity.ok(jwtService.buildJwt(86400L));
    }

    @GetMapping("/decode")
    public ResponseEntity<@NonNull Map<String, Object>> decodeJwt(
            @RequestHeader("Authorization") String auth
    ) {
        String token = auth.substring(7);
        return ResponseEntity.ok(jwtService.decodeJwt(token).getClaims());
    }

}
