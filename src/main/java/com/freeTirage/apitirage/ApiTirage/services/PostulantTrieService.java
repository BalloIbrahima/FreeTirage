package com.freeTirage.apitirage.ApiTirage.services;

import java.util.List;

import com.freeTirage.apitirage.ApiTirage.models.PostulantTrie;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;

public interface PostulantTrieService {

    // Création d'un postulant
    PostulantTrie creerPostulantTrie(PostulantTrie postulanttTrie);

    // retrouver par tirage
    List<PostulantTrie> retrouverParTirage(Tirage tirage);
}
