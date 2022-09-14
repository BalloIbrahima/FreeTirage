package com.freeTirage.apitirage.ApiTirage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Tirage;

@Repository
public interface TirageRepository extends JpaRepository<Tirage, Long> {

    List<Tirage> findByListePostulant(ListePostulant listePostulant);
}
