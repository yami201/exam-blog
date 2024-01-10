package com.example.examblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @JsonIgnore()
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
    private List<Billet> billets;

    public Blog(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Blog(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

    public void addBillets(Billet billet) {
        this.billets.add(billet);
    }

}
