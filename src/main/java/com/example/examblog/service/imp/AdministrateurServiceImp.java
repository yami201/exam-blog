package com.example.examblog.service.imp;

import com.example.examblog.entity.Personne;
import com.example.examblog.repository.PersonneRepository;
import com.example.examblog.service.AdministrateurService;
import com.example.examblog.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministrateurServiceImp implements AdministrateurService {
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne attributeRole(Long id, Role role) {
        return personneRepository
                .findById(id)
                .map(p -> {
                    p.setRole(role);
                    return personneRepository.save(p);
                }).orElse(null);
    }
}
