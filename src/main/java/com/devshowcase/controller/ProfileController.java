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

    // Listar todos
    @GetMapping
    public List<Profile> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile criar(@RequestBody Profile profile) {
        return repository.save(profile);
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Profile> atualizar(@PathVariable Long id, @RequestBody Profile dados) {
        return repository.findById(id)
                .map(p -> {
                    p.setNome(dados.getNome());
                    p.setBio(dados.getBio());
                    p.setEmail(dados.getEmail());
                    return ResponseEntity.ok(repository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}