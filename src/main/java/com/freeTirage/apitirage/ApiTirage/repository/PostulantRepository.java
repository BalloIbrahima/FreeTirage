package com.freeTirage.apitirage.ApiTirage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant, Long> {

}
