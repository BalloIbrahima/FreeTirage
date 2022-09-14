package com.freeTirage.apitirage.ApiTirage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freeTirage.apitirage.ApiTirage.message.ResponseMessage;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;
import com.freeTirage.apitirage.ApiTirage.services.ListePostulantService;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;
import com.freeTirage.apitirage.ApiTirage.services.PostulantTrieService;
import com.freeTirage.apitirage.ApiTirage.services.TirageService;

@CrossOrigin
@RequestMapping("/postulant")
@Controller
public class PostulantController {

    @Autowired
    ListePostulantService listPostulantservice;

    @Autowired
    PostulantService postulantService;

    @Autowired
    TirageService tirageService;

    @Autowired
    PostulantTrieService postulantTrieService;

    // recuperer la recuperation des postulants qui ont ete tirés sur une liste
    @GetMapping("/{idtirage}")
    public ResponseEntity<Object> getTirageListe(@PathVariable(name = "idtirage") Long idtirage) {

        Tirage tirage = tirageService.getTirage(idtirage);

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK,
                    tirage);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.OK, null);
        }

    }

    // recuperer la recuperation d'un postulant
    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getPostulant(@PathVariable(name = "id") Long id) {

        Postulant p = postulantService.RetrouveParId(id);

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK,
                    p);

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.OK, null);
        }

    }
}
