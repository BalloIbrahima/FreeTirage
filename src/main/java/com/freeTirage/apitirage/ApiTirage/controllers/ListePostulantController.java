package com.freeTirage.apitirage.ApiTirage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.services.ListePopulationService;

@RequestMapping("/listePostulant")
@Controller
public class ListePostulantController {

    @Autowired
    ListePopulationService service;

    // pour le création d'une liste
    @PostMapping("/create")
    public Object createListe(@RequestBody ListePostulant liste, @RequestParam("file") MultipartFile file) {

        // vérification de l'existance de la liste
        ListePostulant listePostulant = service.retrouveParLibelle(liste.getLibelle());
        if (liste == null) {
            // La liste n'existe pas, dons on la crée
            return "Cette liste existe deja";

        } else {
            return "Cette liste existe deja";
        }

    }

}
