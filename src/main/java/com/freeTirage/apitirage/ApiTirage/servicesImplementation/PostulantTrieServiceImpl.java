package com.freeTirage.apitirage.ApiTirage.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeTirage.apitirage.ApiTirage.models.PostulantTrie;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;
import com.freeTirage.apitirage.ApiTirage.repository.PostulantTrieRepository;
import com.freeTirage.apitirage.ApiTirage.services.PostulantTrieService;

@Service
public class PostulantTrieServiceImpl implements PostulantTrieService {

    @Autowired
    PostulantTrieRepository respos;

    @Override
    public PostulantTrie creerPostulantTrie(PostulantTrie postulanttTrie) {
        // TODO Auto-generated method stub
        return respos.save(postulanttTrie);
    }

    @Override
    public List<PostulantTrie> retrouverParTirage(Tirage tirage) {
        // TODO Auto-generated method stub
        return respos.findByTirage(tirage);
    }

}
