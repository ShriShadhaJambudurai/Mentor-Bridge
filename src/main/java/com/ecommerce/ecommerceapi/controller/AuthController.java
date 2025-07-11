package com.ecommerce.ecommerceapi.controller;

import com.ecommerce.ecommerceapi.model.User;
import com.ecommerce.ecommerceapi.service.UserService;
import com.ecommerce.ecommerceapi.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        return userService.login(email, password)
                .map(user -> {
                    String token = jwtUtil.generateToken(email);
                    return ResponseEntity.ok(Map.of(
                            "message", "Login successful",
                            "token", token,
                            "user", user
                    ));
                })
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
    }

}
