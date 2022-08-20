package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.repository.ListePostulantRepository;
import com.freeTirage.apitirage.ApiTirage.services.ListePostulantService;

@Service
public class ListePopulationServiceImpl implements ListePostulantService {

    @Autowired
    ListePostulantRepository repos;

    @Override
    public ListePostulant creerListe(ListePostulant listepostulant) {
        // TODO Auto-generated method stub
        return repos.save(listepostulant);
    }

    @Override
    public ListePostulant retrouveParLibelle(String libelle) {
        // TODO Auto-generated method stub
        return repos.findByLibelle(libelle);
    }

    @Override
    public ListePostulant updateListe(ListePostulant listepostulant) {
        // TODO Auto-generated method stub
        return repos.save(listepostulant);
    }

}
