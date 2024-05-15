package org.selfproject.nonoteapp.controller;


import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.selfproject.nonoteapp.repository.noteRepository;
import org.selfproject.nonoteapp.model.noteEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/notes")
public class noteController {

    private final noteRepository noteRepository;

    public noteController(noteRepository noteRepo) {
        this.noteRepository = noteRepo;
    }

    @PostMapping
    public noteEntity createNote(@RequestBody noteEntity noteEntity) {
        return noteRepository.save(noteEntity);
    }


    @GetMapping
    public List<noteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    @PutMapping("/{id}")
    public noteEntity updateNote(@PathVariable String id, @RequestBody noteEntity noteDetails) {
        noteEntity note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id"));

        note.setTitle(noteDetails.getTitle());
        note.setUser(noteDetails.getUser());
        note.setContent(noteDetails.getContent());

        return noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable String id) {
        noteEntity noteEntity = noteRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Note", "id"));
        noteRepository.delete(noteEntity);

        return ResponseEntity.ok().build();
    }



}

