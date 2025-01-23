package com.karan.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthDto {

    private Long userId;

    private String email;

    private String password;

    private String username;

    private String mobileNumber;

}
