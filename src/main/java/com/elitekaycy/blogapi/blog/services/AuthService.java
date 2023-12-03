package com.elitekaycy.blogapi.blog.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.elitekaycy.blogapi.blog.Dtos.AuthenticationResponse;
import com.elitekaycy.blogapi.blog.Dtos.RegisterDto;
import com.elitekaycy.blogapi.blog.Dtos.SignUpDto;
import com.elitekaycy.blogapi.blog.Repository.UserRepository;
import com.elitekaycy.blogapi.blog.models.Role;
import com.elitekaycy.blogapi.blog.models.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

public AuthenticationResponse register(RegisterDto registerDto) throws Exception {
    if(userRepository.existsByEmail(registerDto.getEmail())) {
        throw new Exception("user already exists");
    }
    Users user = new Users();
    user.setName(registerDto.getName());
    user.setEmail(registerDto.getEmail());
    user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
    user.setRole(Role.USER);

    userRepository.save(user);
    var token = jwtService.generateToken(user);

    return AuthenticationResponse.builder().token(token).build();
    
 }

public AuthenticationResponse authenticate(SignUpDto request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
    );
    
    var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("user does not exists"));
    var token = jwtService.generateToken(user);

    return AuthenticationResponse.builder().token(token).build();
}
    
}
