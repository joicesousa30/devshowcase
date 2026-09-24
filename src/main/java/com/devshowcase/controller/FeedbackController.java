package com.devshowcase.controller;

import com.devshowcase.model.Feedback;
import com.devshowcase.repository.FeedbackRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackRepository repository;
    public FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Feedback> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback criar(@RequestBody Feedback feedback) {
        return repository.save(feedback);
    }
}