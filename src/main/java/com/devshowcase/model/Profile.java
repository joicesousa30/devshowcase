package com.devshowcase.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String bio;
    private String email;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Project> projetos = new ArrayList<>();

    // Construtores
    public Profile() {}

    public Profile(String nome, String bio, String email) {
        this.nome = nome;
        this.bio = bio;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Project> getProjetos() { return projetos; }
    public void setProjetos(List<Project> projetos) { this.projetos = projetos; }
}