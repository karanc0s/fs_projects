package com.karan.notes.mapper;

import com.karan.notes.dto.NotesDto;
import com.karan.notes.entity.Note;

public class NotesMapper {
    public static Note mapToNote(NotesDto noteDto, Note note) {
        note.setNoteId(noteDto.getNoteId());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setAuthorId(noteDto.getAuthorId());
        return note;
    }

    public static NotesDto mapToNotesDto(NotesDto noteDto, Note note) {
        noteDto.setNoteId(note.getNoteId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        noteDto.setAuthorId(note.getAuthorId());
        return noteDto;
    }

}
