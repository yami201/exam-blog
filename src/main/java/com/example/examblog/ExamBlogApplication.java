package com.example.examblog;

import com.example.examblog.entity.Blog;
import com.example.examblog.entity.Personne;
import com.example.examblog.repository.BlogRepository;
import com.example.examblog.repository.PersonneRepository;
import com.example.examblog.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;

@SpringBootApplication
public class ExamBlogApplication {
    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    BlogRepository blogRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExamBlogApplication.class, args);
    }


    @Bean
    CommandLineRunner coucou() {
        return args -> {
            personneRepository.save(
                    new Personne(1L,"mamak","mok","mamak@mok.com", Role.ADHERENT)
            );
            personneRepository.save(
                    new Personne(2L,"test","hello","mamak@mok.com", Role.ADHERENT)
            );
            blogRepository.save(
                    new Blog(1L,"My Blog")
            );
        };
    }
}
