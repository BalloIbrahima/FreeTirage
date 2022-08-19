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

import com.freeTirage.apitirage.ApiTirage.configuration.ExelConfig;
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

        // on verifie d'abord si le fichier fornit est de type Excel
        if (ExelConfig.verifier(file)) {
            // vérification de l'existance de la liste dans la base de donnée
            ListePostulant listePostulant = service.retrouveParLibelle(liste.getLibelle());
            if (liste == null) {
                // La liste n'existe pas, dons on la crée
                ListePostulant listeEnregistre = service.creerPListe(liste);
                return "Cette liste existe deja";

            } else {
                // Il existe une liste avec la même libelle
                return "Cette liste existe deja";
            }

        } else {
            // le fichier fournit n'est pas Excel
            return "Veuiller founir un fichier Excel";
        }

    }

}
