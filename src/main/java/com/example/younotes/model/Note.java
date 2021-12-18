package com.example.younotes.model;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer noteId;
    private String title;
    private String body;

    @ManyToOne
    @NotNull
    private NoteBook notebook;



    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public NoteBook getNotebook() {
        return notebook;
    }

    public void setNotebook(NoteBook notebook) {
        this.notebook = notebook;
    }

}
