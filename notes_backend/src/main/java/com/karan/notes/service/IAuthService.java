package com.karan.notes.service;

import com.karan.notes.dto.AuthDto;
import com.karan.notes.dto.AuthResponseDto;

public interface IAuthService {

    AuthResponseDto register(AuthDto authDto);

    AuthResponseDto authenticate(AuthDto authDto);

}
