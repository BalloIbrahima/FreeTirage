package com.freeTirage.apitirage.ApiTirage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulantRepository extends JpaRepository<PostulantRepository, Long> {

}
