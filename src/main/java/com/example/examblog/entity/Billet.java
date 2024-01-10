package com.example.examblog.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "billet")
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private long num;
    private String titre;
    private String contenu;

    @ManyToOne()
    @JoinColumn(name = "blog_id")
    private Blog blog;

    @ManyToOne()
    @JoinColumn(name = "auteur_id",nullable = false)
    private Personne auteur;

    public Billet () {
        this.date = LocalDate.now();
    }

    public Billet(Long id, long num, String titre, String contenu, Blog blog, Personne auteur) {
        this.id = id;
        this.date = LocalDate.now();
        this.num = num;
        this.titre = titre;
        this.contenu = contenu;
        this.blog = blog;
        this.auteur = auteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Personne getAuteur() {
        return auteur;
    }

    public void setAuteur(Personne auteur) {
        this.auteur = auteur;
    }

}
