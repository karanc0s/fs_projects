package com.karan.notes.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class NotesDto {

    private Long noteId;

    private Long authorId;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Content cannot be empty")
    private String content;


}
