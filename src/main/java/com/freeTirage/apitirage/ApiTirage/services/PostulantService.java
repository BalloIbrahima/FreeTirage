package com.freeTirage.apitirage.ApiTirage.services;

import java.util.List;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;

public interface PostulantService {

    // Création d'un postulant
    Postulant creerPostulant(Postulant postulant);

    // Enregistre un ensemble de postulant
    List<Postulant> saveList(List<Postulant> postulants);

}
