package com.example.examblog.service;

import com.example.examblog.entity.Billet;

public interface PersonneService {
    Billet creerBillet(Billet billet,Long blogId, Long auteurId);
    Billet validerBillet(Long billetId, Long blogId);
    Billet publierBillet(Long id);
}
