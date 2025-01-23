package com.karan.notes.controller;

import com.karan.notes.dto.UserDto;
import com.karan.notes.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/update-user")
    public ResponseEntity<UserDto> updateUserDetails(@RequestBody UserDto userDto){
        UserDto updatedUser = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long userId){
        Boolean deleted = userService.deleteUser(userId);
        return ResponseEntity.ok(deleted);
    }

}
