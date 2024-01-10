package com.example.examblog.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "queue")
public class Queue {
    @EmbeddedId
    private QueuePk id;

    @ManyToOne()
    @MapsId(value = "blogId")
    @JoinColumn(name = "blog_id",nullable = false)
    private Blog blog;

    @ManyToOne()
    @MapsId(value = "billetId")
    @JoinColumn(name = "billet_id",nullable = false)
    private Billet billet;


    @Embeddable
    public static class QueuePk implements Serializable {
        private Long blogId;
        private Long billetId;

        public QueuePk(Long blogId, Long billetId) {
            this.blogId = blogId;
            this.billetId = billetId;
        }

        public QueuePk() {}

        public Long getBlogId() {
            return blogId;
        }

        public void setBlogId(Long blogId) {
            this.blogId = blogId;
        }

        public Long getBilletId() {
            return billetId;
        }

        public void setBilletId(Long billetId) {
            this.billetId = billetId;
        }
    }

    public Queue(QueuePk id) {
        this.id = id;
    }
    public Queue(QueuePk id, Blog blog, Billet billet) {
        this.id = id;
        this.blog = blog;
        this.billet = billet;
    }

    public Queue(){}



    public QueuePk getId() {
        return id;
    }

    public void setId(QueuePk id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }
}
