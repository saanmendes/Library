package com.library.controllers;



import com.library.infra.jwt.JwtToken;
import com.library.models.User;
import com.library.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtToken jwtToken;

    public AuthenticationController(UserDetailsServiceImpl userDetailsService, JwtToken jwtToken) {
        this.userDetailsService = userDetailsService;
        this.jwtToken = jwtToken;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody User loginRequest) {
        User user = (User) userDetailsService.loadUserByUsername(loginRequest.getUsername());

        if (user != null && loginRequest.getPassword().equals(user.getPassword())) {
            String token = jwtToken.generateToken(user.getUsername());
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Authentication successful!");
        }

        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

