package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.models.PostulantTrie;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;
import com.freeTirage.apitirage.ApiTirage.repository.PostulantRepository;
import com.freeTirage.apitirage.ApiTirage.repository.PostulantTrieRepository;
import com.freeTirage.apitirage.ApiTirage.repository.TirageRepository;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;

@Service
public class PostulantServiceImpl implements PostulantService {

    @Autowired
    PostulantRepository repos;

    @Autowired
    TirageRepository tirageRepos;

    @Autowired
    PostulantTrieRepository postulantTrieRepos;

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
        List<Long> listId = new ArrayList<>();

        for (Postulant p : list.getPostulants()) {
            listId.add(p.getId());
        }

        System.out.println(listId);
        Collections.shuffle(listId);
        System.out.println(listId);

        for (int i = 1; i <= nombre; i++) {

            Long k = listId.get(i);
            listpostulant.add(repos.findById(k).orElseThrow());

        }

        // creation du trie
        Tirage tirage = new Tirage();
        tirage.setDate(new Date());
        tirage.setLibelle("Resultat" + list.getLibelle() + " " + new Date());
        tirage.setListePostulant(list);

        // enregistrement du tirage
        Tirage tirageSave = tirageRepos.save(tirage);

        // ajout des postulants trie ds la table postulant trie
        for (Postulant p : listpostulant) {
            // Création dans la table postulant tiré le postulant trié
            PostulantTrie postulantTrie = new PostulantTrie();
            postulantTrie.setTirage(tirageSave);
            // atribution du postulant
            postulantTrie.setPostulants(p);
            // atribution du tirage
            postulantTrieRepos.save(postulantTrie);
        }

        return listpostulant;

    }

    @Override
    public Postulant RetrouveParId(Long id) {
        // TODO Auto-generated method stub
        return repos.findById(id).get();
    }

}
