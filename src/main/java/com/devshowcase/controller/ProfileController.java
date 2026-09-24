package com.devshowcase.controller;

import com.devshowcase.model.Profile;
import com.devshowcase.repository.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Profile> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile criar(@RequestBody Profile profile) {
        return repository.save(profile);
    }
}
