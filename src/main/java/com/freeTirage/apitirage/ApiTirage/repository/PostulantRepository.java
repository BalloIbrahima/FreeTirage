package com.freeTirage.apitirage.ApiTirage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freeTirage.apitirage.ApiTirage.models.ListePostulant;
import com.freeTirage.apitirage.ApiTirage.models.Postulant;

@Repository
public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    Postulant findByEmail(String email);

    @Query(value = "SELECT * FROM user ORDER BY RAND() LIMIT :nombre", nativeQuery = true)
    List<Postulant> Aleatoire(@Param("nombre") Integer nombre);

    List<Postulant> findByListePostulant(ListePostulant listePostulant);
}
