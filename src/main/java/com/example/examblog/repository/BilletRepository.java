package com.example.examblog.repository;

import com.example.examblog.entity.Billet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BilletRepository extends JpaRepository<Billet,Long> {
}
