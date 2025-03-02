package com.karan.notes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    private Long userId;

    @Size(
            min = 5,
            max = 30,
            message = "The Length of the username should be between 5 and 30"
    )
    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
    )
    @NotEmpty(message = "Mobile cannot be empty")
    private String mobileNumber;


//    @Size(min = 8, message = "Password have minimum length of 8")
    private String password;


}
