package com.example.examblog.service.imp;

import com.example.examblog.entity.Billet;
import com.example.examblog.entity.Blog;
import com.example.examblog.entity.Queue;
import com.example.examblog.repository.BilletRepository;
import com.example.examblog.repository.BlogRepository;
import com.example.examblog.repository.PersonneRepository;
import com.example.examblog.repository.QueueRepository;
import com.example.examblog.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneServiceImp implements PersonneService {
    @Autowired
    private BilletRepository billetRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Billet creerBillet(Billet billet,Long blogId, Long auteurId) {
        billet.setBlog(null);
        billet.setAuteur(
                personneRepository.findById(auteurId).orElse(null)
        );
        Billet b = billetRepository.save(billet);
        System.out.println(billet.getId() + " " + blogId);
        queueRepository.save(
                new Queue(
                        new Queue.QueuePk(
                                blogId,
                                b.getId()
                        ),
                        blogRepository.findById(blogId).orElse(null),
                        b
                )
        );
        return b;
    }

    @Override
    public Billet validerBillet(Long billetId, Long blogId) {
        return billetRepository.findById(billetId)
                .map(billet -> {
                    blogRepository.findById(blogId)
                            .ifPresent(
                                blog -> {
                                    billet.setBlog(blog);
                                    blog.addBillets(billet);
                                    queueRepository.deleteById(new Queue.QueuePk(blogId,billetId));
                                }
                            );
                    return billet;
                }).orElse(null);
    }

    @Override
    public Billet publierBillet(Long id) {
        return null;
    }
}
