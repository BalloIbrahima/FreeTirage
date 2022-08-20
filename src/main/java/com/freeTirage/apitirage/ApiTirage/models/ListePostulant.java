package com.freeTirage.apitirage.ApiTirage.models;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
public class ListePostulant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    Date date;
    String libelle;

    @ManyToMany
    @JoinTable(name = "PostulantListe", joinColumns = { @JoinColumn(name = "id_liste") }, inverseJoinColumns = {
            @JoinColumn(name = "id_postulant") })
    List<Postulant> postulants = new ArrayList<>();

    @OneToMany(mappedBy = "listePostulant")
    List<Tirage> tirages = new ArrayList<>();

}
