package com.karan.notes.service;

import com.karan.notes.dto.NotesDto;
import com.karan.notes.entity.Note;
import com.karan.notes.exception.NoteNotFoundException;
import com.karan.notes.mapper.NotesMapper;
import com.karan.notes.repository.NotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class NotesService implements INotesService {

    private final NotesRepository notesRepository;

    @Override
    public List<NotesDto> getAllNotes() {

        return notesRepository.findAll()
                .stream()
                .map(note -> NotesMapper.mapToNotesDto(
                        new NotesDto(),
                        note)
                )
                .toList();
    }

    @Override
    public List<NotesDto> getMyNotes(Long authorId) {
        return notesRepository.findAllByAuthorId(authorId)
                .stream()
                .map(note -> NotesMapper.mapToNotesDto(
                        new NotesDto(),
                        note)
                )
                .toList();
    }

    @Override
    public NotesDto getNoteById(Long id) {
        Note note =  notesRepository.findById(id).orElseThrow(
                () -> new NoteNotFoundException(id)
        );
        return NotesMapper.mapToNotesDto(new NotesDto(), note);
    }

    @Override
    public NotesDto createNote(NotesDto notesDto) {
        Note note = NotesMapper.mapToNote(notesDto , new Note());
        System.out.println(note.toString());
        note = notesRepository.save(note);
        return NotesMapper.mapToNotesDto(new NotesDto(), note);
    }

    @Override
    public NotesDto updateNote(NotesDto notesDto) {
        Note note = notesRepository.findById(notesDto.getNoteId()).orElseThrow(
                () -> new NoteNotFoundException(notesDto.getNoteId())
        );

        Note updatedNote = NotesMapper.mapToNote(notesDto , note);
        notesRepository.save(updatedNote);

        return NotesMapper.mapToNotesDto(new NotesDto(), updatedNote);
    }

    @Override
    public Boolean deleteNote(Long id) {
        notesRepository.deleteById(id);
        return true;
    }
}
