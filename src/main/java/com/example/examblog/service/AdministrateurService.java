package com.example.examblog.service;

import com.example.examblog.entity.Personne;
import com.example.examblog.type.Role;

import java.util.Optional;

public interface AdministrateurService {
    public Personne attributeRole(Long id, Role role);
}
