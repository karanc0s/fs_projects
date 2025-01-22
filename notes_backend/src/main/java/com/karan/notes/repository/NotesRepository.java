package com.karan.notes.repository;

import com.karan.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends JpaRepository<Note , Long> {

    List<Note> findAllByAuthorId(Long authorId);

}
