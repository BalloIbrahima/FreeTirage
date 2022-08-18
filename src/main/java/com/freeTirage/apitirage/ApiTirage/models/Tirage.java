package com.freeTirage.apitirage.ApiTirage.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Date date;
    String libelle;

    @ManyToMany(mappedBy = "tirages")
    List<Postulant> postulants = new ArrayList<>();
}
