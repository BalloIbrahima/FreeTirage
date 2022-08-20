package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;
import com.freeTirage.apitirage.ApiTirage.repository.PostulantRepository;
import com.freeTirage.apitirage.ApiTirage.repository.TirageRepository;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;

@Service
public class PostulantServiceImpl implements PostulantService {

    @Autowired
    PostulantRepository repos;

    @Autowired
    TirageRepository tirageRepos;

    @Override
    public Postulant creerPostulant(Postulant postulant) {
        // TODO Auto-generated method stub
        return repos.save(postulant);
    }

    @Override
    public List<Postulant> saveList(List<Postulant> postulants) {
        // TODO Auto-generated method stub

        for (Postulant p : postulants) {
            if (repos.findByEmail(p.getEmail()) == null) {
                repos.save(p);
            }

        }
        return postulants;
    }

    @Override
    public Postulant RetrouveParMail(String email) {
        // TODO Auto-generated method stub
        return repos.findByEmail(email);
    }

    @Override
    public List<Postulant> listeAleatoire(int nombre) {
        // TODO Auto-generated method stub
        return repos.Aleatoire(nombre);
    }

    @Override
    public List<Postulant> tirage(ListePostulant list, int nombre) {

        // declaration de la liste qui sera retourne
        List<Postulant> listpostulant = new ArrayList<>();

        // recuperation du nombre de postulant

        // creation d'une variable random
        Random rd = new Random();
        // une variable qui va contenir la liste des ids selectionnés
        List<Integer> listId = new ArrayList<>();
        for (int i = 0; i < nombre; i++) {
            Integer idCoisi = rd.nextInt(list.getPostulants().size());

            if (idCoisi == 0 || listId.contains(idCoisi)) {
                idCoisi = rd.nextInt(list.getPostulants().size());
            }
            // ajout a la liste des ids
            listId.add(idCoisi);
            // ajout du postulant dans la liste de postulant trié
            listpostulant.add(list.getPostulants().get(idCoisi));

        }

        // creation du trie
        Tirage tirage = new Tirage();
        tirage.setDate(new Date());
        tirage.setLibelle("Resultat" + list.getLibelle());

        // enregistrement du tirage
        Tirage tirageSave = tirageRepos.save(tirage);
        // atribution du tirage

        return listpostulant;

    }

}
