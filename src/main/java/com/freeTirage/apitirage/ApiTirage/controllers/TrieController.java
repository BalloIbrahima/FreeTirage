package com.freeTirage.apitirage.ApiTirage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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

            return ResponseMessage.generateResponse("ok", HttpStatus.OK, postulants);

        } else {
            return ResponseMessage.generateResponse("Cette liste n'existe pas dans la base de donnée",
                    HttpStatus.OK, null);
        }

    }

    // recuperer la recuperation des tries qui ont ete effecués sur une liste
    @GetMapping("/{idliste}")
    public ResponseEntity<Object> getTirageListe(@PathVariable(name = "idliste") Long idliste) {

        ListePostulant list = listePostulantService.retrouveParId(idliste);

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK,
                    list);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.OK, null);
        }

    }

    // recuperer le nombre de liste
    @GetMapping("/nombre")
    public ResponseEntity<Object> nombreTirage() {

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK, service.nombre());

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.OK, null);
        }

    }

}
