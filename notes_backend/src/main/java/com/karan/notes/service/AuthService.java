package com.karan.notes.service;

import com.karan.notes.dto.AuthDto;
import com.karan.notes.dto.AuthResponseDto;
import com.karan.notes.entity.PrincipalUser;
import com.karan.notes.exception.UserAlreadyExistsException;
import com.karan.notes.exception.UserNotFoundException;
import com.karan.notes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto register(AuthDto authDto) {

        Optional<PrincipalUser> principalUser = userRepository.findByUsername(authDto.getUsername());
        if(principalUser.isPresent()) {
            throw new UserAlreadyExistsException("User with this username already exists");
        }

        PrincipalUser user = new PrincipalUser();
        user.setEmail(authDto.getEmail());
        user.setUsername(authDto.getUsername());
        user.setMobileNumber(authDto.getMobileNumber());
        user.setPassword(passwordEncoder.encode(authDto.getPassword()));

        user = userRepository.save(user);

        String token = jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .userId(user.getUserId())
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .build();
    }

    @Override
    public AuthResponseDto authenticate(AuthDto authDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authDto.getUsername(),
                        authDto.getPassword()
                )
        );
        if(!authentication.isAuthenticated()) {
            throw new UserNotFoundException("User not found. Please check credentials");
        }
        PrincipalUser user = userRepository.findByUsername(authDto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(user);
        return AuthResponseDto.builder()
                .userId(user.getUserId())
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .mobileNumber(user.getMobileNumber())
                .build();
    }
}
