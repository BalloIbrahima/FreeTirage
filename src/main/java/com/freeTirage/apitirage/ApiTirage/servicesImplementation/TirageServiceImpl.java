package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.Tirage;
import com.freeTirage.apitirage.ApiTirage.repository.TirageRepository;
import com.freeTirage.apitirage.ApiTirage.services.TirageService;

@Service
public class TirageServiceImpl implements TirageService {

    @Autowired
    TirageRepository repos;

    @Override
    public Tirage creerTirage(Tirage tirage) {
        // TODO Auto-generated method stub
        return repos.save(tirage);
    }

    @Override
    public Tirage modifierTirage(Tirage tirage) {
        // TODO Auto-generated method stub
        return repos.save(tirage);
    }

}
