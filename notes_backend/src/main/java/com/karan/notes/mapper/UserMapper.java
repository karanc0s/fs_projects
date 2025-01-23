package com.karan.notes.mapper;

import com.karan.notes.dto.UserDto;
import com.karan.notes.entity.PrincipalUser;

public class UserMapper {

    public static PrincipalUser mapToPrincipalUser(PrincipalUser user , UserDto userDto) {

        user.setUserId(userDto.getUserId());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setPassword(userDto.getPassword());

        return user;
    }
    public static UserDto mapToUserDto(PrincipalUser user , UserDto userDto) {

        userDto.setUserId(user.getUserId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
