package com.karan.notes.service;

import com.karan.notes.dto.NotesDto;

import java.util.List;

public interface INotesService {

    List<NotesDto> getAllNotes();

    List<NotesDto> getMyNotes(Long userId);

    NotesDto getNoteById(Long id);

    NotesDto createNote(NotesDto notesDto);

    NotesDto updateNote(NotesDto notesDto);

    Boolean deleteNote(Long id);

}
