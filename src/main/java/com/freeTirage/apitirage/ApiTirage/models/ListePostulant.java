package com.freeTirage.apitirage.ApiTirage.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Date date;
    String libelle;

    @OneToMany(mappedBy = "listePostulant")
    List<Postulant> postulants = new ArrayList<>();

}
