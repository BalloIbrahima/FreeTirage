package com.freeTirage.apitirage.ApiTirage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeTirage.apitirage.ApiTirage.message.ResponseMessage;
import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.services.ListePostulantService;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;
import com.freeTirage.apitirage.ApiTirage.services.TirageService;

@RequestMapping("/trie")
@Controller
public class TrieController {

    @Autowired
    TirageService service;

    @Autowired
    ListePostulantService listePostulantService;

    @Autowired
    PostulantService postulantService;

    // pour la création d'un trie
    @GetMapping("/{libelle}/{nombre}")
    public ResponseEntity<Object> createListe(@PathVariable(value = "libelle") String libelle,
            @PathVariable(value = "nombre") Integer nombre) {

        ListePostulant listePostulant = listePostulantService.retrouveParLibelle(libelle);
        if (listePostulant != null) {
            List<Postulant> postulants = postulantService.tirage(listePostulant, nombre);

            // atribution du tirage

            return ResponseMessage.generateResponse("le trie", HttpStatus.OK, postulants);

        } else {
            return ResponseMessage.generateResponse("Cette liste n'existe pas dans la base de donnée",
                    HttpStatus.NOT_FOUND, null);
        }

    }

}
