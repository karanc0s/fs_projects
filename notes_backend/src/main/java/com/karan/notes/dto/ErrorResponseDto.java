package com.karan.notes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;

    private String errorMessage;

    private LocalDateTime errorTime;

}
