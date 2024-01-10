package com.example.examblog.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "map")
public class Map {
    @EmbeddedId
    private MapPk id;

    @ManyToOne
    @MapsId("blogId")
    @JoinColumn(name = "blog_id", nullable = false)
    private Blog blog;

    @ManyToOne
    @MapsId("adherentId")
    @JoinColumn(name = "adherent_id", nullable = false)
    private Personne adherent;

    public static class MapPk implements Serializable{
        private Long blogId;
        private Long adherentId;

        public MapPk(Long blogId, Long adherentId) {
            this.blogId = blogId;
            this.adherentId = adherentId;
        }

        public Long getBlogId() {
            return blogId;
        }

        public void setBlogId(Long blogId) {
            this.blogId = blogId;
        }

        public Long getAdherentId() {
            return adherentId;
        }

        public void setAdherentId(Long adherentId) {
            this.adherentId = adherentId;
        }
    }

    public Map(MapPk id) {
        this.id = id;
    }

    public Map(){

    }

    public MapPk getId() {
        return id;
    }

    public void setId(MapPk id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Personne getAdherent() {
        return adherent;
    }

    public void setAdherent(Personne adherent) {
        this.adherent = adherent;
    }
}
