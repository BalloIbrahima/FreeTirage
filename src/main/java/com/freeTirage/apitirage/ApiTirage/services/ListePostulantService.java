package com.freeTirage.apitirage.ApiTirage.services;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;

public interface ListePostulantService {
    // Création d'un Liste de population
    ListePostulant creerListe(ListePostulant listepostulant);

    // Mettre à jour la Liste de population
    ListePostulant updateListe(ListePostulant listepostulant);

    // Retrouver la liste à travers la libelle
    ListePostulant retrouveParLibelle(String libelle);

}
