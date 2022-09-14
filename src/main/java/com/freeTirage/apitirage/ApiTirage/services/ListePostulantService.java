package com.freeTirage.apitirage.ApiTirage.services;

import java.util.List;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;

public interface ListePostulantService {
    // Création d'un Liste de population
    ListePostulant creerListe(ListePostulant listepostulant);

    // Mettre à jour la Liste de population
    ListePostulant updateListe(ListePostulant listepostulant);

    // Retrouver la liste à travers la libelle
    ListePostulant retrouveParId(Long id);

    // Retrouver la liste à travers l'id
    ListePostulant retrouveParLibelle(String libelle);

    // l'nsemble des listes
    List<ListePostulant> laListe();

    // nombre de liste
    Long nombre();
}
