package com.freeTirage.apitirage.ApiTirage.services;

import java.util.List;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;

public interface PostulantService {

    // Création d'un postulant
    Postulant creerPostulant(Postulant postulant);

    // Enregistre un ensemble de postulant
    List<Postulant> saveList(List<Postulant> postulants);

    Postulant RetrouveParMail(String email);

    // methode qui retourne la liste aleatoire
    List<Postulant> listeAleatoire(int nombre);

    // trirage aleatoire
    List<Postulant> tirage(ListePostulant list, int nombre);

}
