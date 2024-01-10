package com.example.examblog.entity;

import com.example.examblog.type.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "administrateur")

public class Administrateur extends Personne{

    @OneToOne()
    @JoinColumn(name = "blog_id",nullable = false)
    Blog blog;

    public Administrateur(){}

    public Administrateur(Long id, String nom, String prenom, String email, Role role, Blog blog) {
        super(id, nom, prenom, email, Role.GERENT);
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
