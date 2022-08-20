package com.freeTirage.apitirage.ApiTirage.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Date date;
    String libelle;

    @ManyToOne
    @JoinColumn(name = "id_liste")
    ListePostulant listePostulant;

    @OneToMany(mappedBy = "tirage")
    List<PostulantTrie> postulantTries = new ArrayList<>();
}
