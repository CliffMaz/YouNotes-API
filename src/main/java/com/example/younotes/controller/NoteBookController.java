package com.example.younotes.controller;


import com.example.younotes.model.NoteBook;
import com.example.younotes.repo.NoteBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notebooks")
@CrossOrigin(origins="*")
public class NoteBookController {


    private NoteBookRepo noteBookService;

    @Autowired
    public NoteBookController(NoteBookRepo noteBookService) {
        this.noteBookService = noteBookService;
    }

    @GetMapping("/all")
    public List<NoteBook> all() {
        List<NoteBook> allCategories = this.noteBookService.findAll();
        return allCategories;
    }

    @PostMapping("/save")
    public NoteBook save(@RequestBody NoteBook noteBook) {

        // save notebookEntity instance to db
        this.noteBookService.save(noteBook);

        return noteBook;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.noteBookService.deleteById(id);
    }
}
