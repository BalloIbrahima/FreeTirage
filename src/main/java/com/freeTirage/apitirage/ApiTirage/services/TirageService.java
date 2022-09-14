package com.freeTirage.apitirage.ApiTirage.services;

import java.util.List;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;

public interface TirageService {
    // Création d'un Tirage
    Tirage creerTirage(Tirage tirage);

    // Modification d'un postulant
    Tirage modifierTirage(Tirage tirage);

    // Retrouver tirage par id
    Tirage getTirage(Long id);

    // nombre de liste
    Long nombre();

    // Recuperer des tirages d'une liste
    List<Tirage> getTirageListe(ListePostulant listePostulant);
}
