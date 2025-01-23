package com.karan.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthResponseDto {

    private Long userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String token;
}
