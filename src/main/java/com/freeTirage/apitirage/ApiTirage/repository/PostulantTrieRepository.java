package com.freeTirage.apitirage.ApiTirage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeTirage.apitirage.ApiTirage.models.PostulantTrie;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;

@Repository
public interface PostulantTrieRepository extends JpaRepository<PostulantTrie, Long> {

    List<PostulantTrie> findByTirage(Tirage tirage);
}
