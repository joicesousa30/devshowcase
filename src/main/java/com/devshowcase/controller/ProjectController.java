package com.devshowcase.controller;

import com.devshowcase.model.Project;
import com.devshowcase.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectRepository repository;
    public ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Project> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project criar(@RequestBody Project project) {
        return repository.save(project);
    }
}