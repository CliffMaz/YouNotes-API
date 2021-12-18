package com.example.younotes.service;
import com.example.younotes.model.Note;
import com.example.younotes.model.NoteBook;
import com.example.younotes.repo.NoteRepo;
import com.example.younotes.model.Note;
import com.example.younotes.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class NoteService {

    NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {

        this.noteRepo=noteRepo;
    }

    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Note findNoteById(Integer id){

        return noteRepo.getById(id);
    }

    public List<Note> findAllNotesByNotebook(NoteBook notebook) {
        return noteRepo.findByNotebook(notebook);
    }
public Note save(Note note) {
       return noteRepo.save(note);
    }

public void deleteNoteById(Integer id) {

    noteRepo.deleteById(id);
}

}
