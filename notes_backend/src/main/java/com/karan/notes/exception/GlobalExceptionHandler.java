package com.karan.notes.exception;

import com.karan.notes.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleUserAlreadyExistsException(UserAlreadyExistsException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponseDto.builder()
                        .apiPath(request.getDescription(false))
                        .errorMessage(ex.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
        );
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponseDto.builder()
                        .apiPath(request.getDescription(true))
                        .errorMessage(ex.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
        );
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ErrorResponseDto.builder()
                        .apiPath(request.getDescription(false))
                        .errorMessage(ex.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
        );
    }



}
