package com.example.examblog.repository;

import com.example.examblog.entity.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
