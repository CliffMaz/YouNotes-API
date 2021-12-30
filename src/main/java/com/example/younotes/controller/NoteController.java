package com.example.younotes.controller;

import com.example.younotes.model.Note;
import com.example.younotes.model.NoteBook;
import com.example.younotes.repo.NoteBookRepo;
import com.example.younotes.repo.NoteRepo;
import com.example.younotes.service.NoteBookService;
import com.example.younotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/notes")

public class NoteController {

    private final NoteService noteService;
    private final NoteBookService noteBookService;
    private List<Note> notes;

    @Autowired
    public NoteController(NoteService noteService, NoteBookService noteBookService) {
        this.noteService=noteService;
        this.noteBookService=noteBookService;
    }
    

    @GetMapping("/all")
    public List<Note> getAllNotes(){

        notes=noteService.getAllNotes();

        return notes;
    }

    @GetMapping("/{id}")
    public Note byId(@PathVariable Integer id) {
        Note note = this.noteService.findNoteById(id);

        return note;
    }

    @GetMapping("/byNotebook/{notebookId}")
    public List<Note> byNotebook(@PathVariable Integer notebookId) {
        List<Note> notes = new ArrayList<>();

        NoteBook notebook = this.noteBookService.findById(notebookId);
        if (notebook!=null) {
            notes = this.noteService.findAllNotesByNotebook(notebook);
        }

        return notes;
    }

    @PostMapping("/save")
    public Note save(@RequestBody Note note) {

        // save note instance to db
        this.noteService.save(note);

        return note;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.noteService.deleteNoteById(id);
    }
}
