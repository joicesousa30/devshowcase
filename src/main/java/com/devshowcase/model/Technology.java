package com.devshowcase.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nivel; // iniciante, intermediário, avançado

    @ManyToMany(mappedBy = "tecnologias")
    private List<Project> projetos = new ArrayList<>();

    // Construtores
    public Technology() {}

    public Technology(String nome, String nivel) {
        this.nome = nome;
        this.nivel = nivel;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }

    public List<Project> getProjetos() { return projetos; }
    public void setProjetos(List<Project> projetos) { this.projetos = projetos; }
}