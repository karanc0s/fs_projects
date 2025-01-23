package com.karan.notes.controller;

import com.karan.notes.dto.AuthDto;
import com.karan.notes.dto.AuthResponseDto;
import com.karan.notes.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthDto authDto){
        return ResponseEntity.ok(authService.authenticate(authDto));
    }


    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> createAccount(@RequestBody AuthDto authDto){
        return ResponseEntity.ok(authService.register(authDto));
    }


}
