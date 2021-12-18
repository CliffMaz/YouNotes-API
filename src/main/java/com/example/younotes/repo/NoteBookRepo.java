package com.example.younotes.repo;

import com.example.younotes.model.NoteBook;
import com.example.younotes.model.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteBookRepo extends JpaRepository<NoteBook, Integer> {

    //NoteBook findNoteBookByNoteBookId(UUID id);
}
