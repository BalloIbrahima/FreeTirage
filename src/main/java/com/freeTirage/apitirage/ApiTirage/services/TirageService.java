package com.freeTirage.apitirage.ApiTirage.services;

import com.freeTirage.apitirage.ApiTirage.models.Tirage;

public interface TirageService {
    // Création d'un Tirage
    Tirage creerTirage(Tirage tirage);

    // Modification d'un postulant
    Tirage modifierTirage(Tirage tirage);

}
