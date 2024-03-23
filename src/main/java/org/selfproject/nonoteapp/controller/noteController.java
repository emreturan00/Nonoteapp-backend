package org.selfproject.nonoteapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.selfproject.nonoteapp.repository.noteRepository;
import org.selfproject.nonoteapp.model.noteEntity;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class noteController {

    private final noteRepository noteRepository;

    public noteController(noteRepository noteRepo){
        this.noteRepository = noteRepo;
    }

    @GetMapping
    public List<noteEntity> getAllNotes(){
        return noteRepository.findAll();
    }




}
