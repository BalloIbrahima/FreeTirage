package com.freeTirage.apitirage.ApiTirage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeTirage.apitirage.ApiTirage.models.PostulantTrie;

@Repository
public interface PostulantTrieRepository extends JpaRepository<PostulantTrie, Long> {

}
