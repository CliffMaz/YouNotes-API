package com.example.younotes.repo;

import com.example.younotes.model.Note;

import com.example.younotes.model.NoteBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface  NoteRepo extends JpaRepository<Note,Integer> {


    List<Note> findByNotebook(NoteBook noteBook);



}
