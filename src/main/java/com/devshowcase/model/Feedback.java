package com.devshowcase.model;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;
    private String comentario;
    private Integer nota; // de 1 a 5

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    // Construtores
    public Feedback() {}

    public Feedback(String autor, String comentario, Integer nota, Project project) {
        this.autor = autor;
        this.comentario = comentario;
        this.nota = nota;
        this.project = project;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}