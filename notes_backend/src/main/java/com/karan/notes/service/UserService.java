package com.karan.notes.service;

import com.karan.notes.dto.UserDto;
import com.karan.notes.entity.PrincipalUser;
import com.karan.notes.exception.UserNotFoundException;
import com.karan.notes.mapper.UserMapper;
import com.karan.notes.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    private UserRepository userRepository;


    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<PrincipalUser> user = userRepository.findById(userDto.getUserId());
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        PrincipalUser updatedUser = UserMapper.mapToPrincipalUser(user.get() , userDto);
        updatedUser = userRepository.save(updatedUser);
        return UserMapper.mapToUserDto(updatedUser , new UserDto());
    }

    @Override
    public Boolean deleteUser(Long userId) {
        Optional<PrincipalUser> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(userId);
        return true;
    }
}
