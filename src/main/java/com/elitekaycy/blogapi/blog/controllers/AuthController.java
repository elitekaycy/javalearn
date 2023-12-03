package com.elitekaycy.blogapi.blog.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitekaycy.blogapi.blog.Dtos.AuthenticationResponse;
import com.elitekaycy.blogapi.blog.Dtos.RegisterDto;
import com.elitekaycy.blogapi.blog.Dtos.SignUpDto;

import com.elitekaycy.blogapi.blog.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterDto registerDto) throws Exception {
        return ResponseEntity.ok(authService.register(registerDto));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody SignUpDto request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @GetMapping("/")
    public ResponseEntity<String> main() {
        return ResponseEntity.ok("working routes");
    }

    

    
}
