package com.freeTirage.apitirage.ApiTirage.repository;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportPostulantRepository extends JpaRepository<Postulant, Long> {
}
