package com.example.examblog.controller;

import com.example.examblog.entity.Billet;
import com.example.examblog.entity.Personne;
import com.example.examblog.repository.PersonneRepository;
import com.example.examblog.service.AdministrateurService;
import com.example.examblog.service.PersonneService;
import com.example.examblog.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlleur {
    @Autowired
    AdministrateurService administrateurService;

    @Autowired
    PersonneService personneService;

    @Autowired
    PersonneRepository personneRepository;

    @PatchMapping("/role")
    public ResponseEntity<Personne> attributeRole(@RequestParam Long id,@RequestParam Role role) {
        return new ResponseEntity<>(administrateurService.attributeRole(id,role),HttpStatus.OK);
    }

    @PostMapping("/creer/{blogId}/{auteurId}")
    public ResponseEntity<Billet> creerBillet(
            @PathVariable long auteurId,
            @PathVariable long blogId,
            @RequestBody Billet billet){
        return new ResponseEntity<>(personneService.creerBillet(billet,blogId, auteurId),HttpStatus.OK);
    }

    @PatchMapping("/validate/{blogId}/{billetId}")
    public ResponseEntity<Billet> validateBillet(
            @PathVariable long blogId,
            @PathVariable long billetId
    ) {
        return new ResponseEntity<>(personneService.validerBillet(blogId,billetId),HttpStatus.OK);
    }
}
