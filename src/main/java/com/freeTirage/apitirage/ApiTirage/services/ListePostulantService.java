package com.freeTirage.apitirage.ApiTirage.services;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;

public interface ListePostulantService {
    // Création d'un Liste de population
    ListePostulant creerPListe(ListePostulant listepostulant);

    // Retrouver la liste à travers la libelle
    ListePostulant retrouveParLibelle(String libelle);
}
