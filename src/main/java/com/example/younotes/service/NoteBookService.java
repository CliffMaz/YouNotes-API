package com.example.younotes.service;


import com.example.younotes.model.NoteBook;
import com.example.younotes.repo.NoteBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NoteBookService {

    NoteBookRepo noteBookRepo;

    @Autowired
    public NoteBookService(NoteBookRepo noteBookRepo) {
        this.noteBookRepo=noteBookRepo;
    }

    /*public NoteBook findNoteBookByNoteBookId(UUID id) {

        return noteBookRepo.findNoteBookByNoteBookId(id);
    }
*/
    public NoteBook findById(Integer id) {
       return noteBookRepo.getById(id);
    }
}
