package com.karan.notes.controller;

import com.karan.notes.dto.NotesDto;
import com.karan.notes.service.INotesService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api1")
public class NotesController {

    private final INotesService notesService;

    @GetMapping("/notes")
    public ResponseEntity<List<NotesDto>> getAllNotes() {
        return ResponseEntity.ok(notesService.getAllNotes());
    }

    @GetMapping("/my-notes")
    public ResponseEntity<List<NotesDto>> getMyNotes(@Param("authorId") Long authorId) {
        return ResponseEntity.ok(notesService.getMyNotes(authorId));
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NotesDto> getNote(@PathVariable("id") Long noteId) {
        NotesDto notesDto = notesService.getNoteById(noteId);
        return ResponseEntity.ok(notesDto);
    }

    @PostMapping("/create")
    public ResponseEntity<NotesDto> createNote(@RequestBody NotesDto notesDto) {
        NotesDto note = notesService.createNote(notesDto);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/update")
    public ResponseEntity<NotesDto> updateNote(@RequestBody NotesDto notesDto) {
        NotesDto note = notesService.updateNote(notesDto);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNote(@PathVariable("id") Long noteId) {
        Boolean status = notesService.deleteNote(noteId);
        return ResponseEntity.ok(status);
    }

}
