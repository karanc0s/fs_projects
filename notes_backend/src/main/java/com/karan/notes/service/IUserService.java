package com.karan.notes.service;

import com.karan.notes.dto.UserDto;

public interface IUserService {


    UserDto updateUser(UserDto userDto);

    Boolean deleteUser(Long userId);

}
