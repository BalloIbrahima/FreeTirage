package com.freeTirage.apitirage.ApiTirage.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.freeTirage.apitirage.ApiTirage.configuration.ExelConfig;
import com.freeTirage.apitirage.ApiTirage.message.ResponseMessage;
import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.services.ListePostulantService;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;

@CrossOrigin
@RequestMapping("/listePostulant")
@Controller
public class ListePostulantController {

    @Autowired
    ListePostulantService service;

    @Autowired
    PostulantService postulantService;

    // pour la création d'une liste
    @PostMapping("/create/{libelle}/{nombre}")
    public ResponseEntity<Object> createListe(@RequestParam("file") MultipartFile file,
            @PathVariable(value = "libelle") String libelle, @PathVariable(value = "nombre") Integer nombre)
            throws IOException {

        // String nomfile[] = file.getOriginalFilename().split(".");
        // String libelle = nomfile[0].toString();
        // System.out.println(file.getOriginalFilename());
        // on verifie d'abord si le fichier fornit est de type Excel
        if (ExelConfig.verifier(file)) {
            // vérification de l'existance de la liste dans la base de donnée
            ListePostulant listePostulant = service.retrouveParLibelle(libelle);
            if (listePostulant == null) {
                // La liste n'existe pas, donc on la crée
                ListePostulant lp = new ListePostulant();
                lp.setDate(new Date());

                lp.setLibelle(libelle);

                // après la creation de la liste on va enregistre les postulants qui etataient
                // dans la liste
                // Dabord on recupère les postulants
                List<Postulant> postulants = ExelConfig.postulantsExcel(file);
                // ListePostulant listeEnregistre = new ListePostulant();
                // on vas attribuer les postulants à la liste qu'on a crée ci dessus
                // for (Postulant p : postulants) {
                // lp.getPostulants().add(p);
                // }

                // ListePostulant listeSave = service.creerListe(lp);

                for (Postulant p : postulants) {

                    if (postulantService.RetrouveParMail(p.getEmail()) == null
                            & p.getNom() != null & p.getPrenom() != null) {
                        Postulant pc = postulantService.creerPostulant(p);

                        p.getListePostulant().add(lp);
                        lp.getPostulants().add(pc);

                    } else if (p.getEmail() != null & p.getNom() != null & p.getPrenom() != null) {
                        Postulant pc = postulantService.RetrouveParMail(p.getEmail());
                        lp.getPostulants().add(pc);

                    }

                }

                return ResponseMessage.generateResponse("ok", HttpStatus.OK,
                        postulantService.tirage(service.creerListe(lp), nombre));

            } else {
                // Il existe une liste avec la même libelle
                return ResponseMessage.generateResponse("Cette lise existe deja", HttpStatus.OK, null);
            }

        } else {
            // le fichier fournit n'est pas Excel
            return ResponseMessage.generateResponse("Veuiller fournir un fichier Excel valide!", HttpStatus.OK,
                    null);

        }

    }

    // recupere la liste des listes
    @GetMapping("/list")
    public ResponseEntity<Object> Liste() {

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK, service.laListe());

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.OK, null);
        }

    }

    // recuperer le nombre de liste
    @GetMapping("/nombre")
    public ResponseEntity<Object> nombreListe() {

        try {
            return ResponseMessage.generateResponse("ok", HttpStatus.OK, service.nombre());

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseMessage.generateResponse("Erreur",
                    HttpStatus.NOT_FOUND, null);
        }

    }
}
