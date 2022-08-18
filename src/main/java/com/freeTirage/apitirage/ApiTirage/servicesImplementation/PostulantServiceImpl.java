package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import com.freeTirage.apitirage.ApiTirage.repository.PostulantRepository;
import com.freeTirage.apitirage.ApiTirage.services.PostulantService;

@Service
public class PostulantServiceImpl implements PostulantService {

    @Autowired
    PostulantRepository repos;

    @Override
    public Postulant creerPostulant(Postulant postulant) {
        // TODO Auto-generated method stub
        return repos.save(postulant);
    }

}
