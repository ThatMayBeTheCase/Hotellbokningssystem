package se.grupp3.hotellbokningssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import se.grupp3.hotellbokningssystem.dto.AuthRequest;
import se.grupp3.hotellbokningssystem.security.JwtUtil;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(),
            authRequest.getPassword()
        ));

        String token = jwtUtil.generateToken(authRequest.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }
}
