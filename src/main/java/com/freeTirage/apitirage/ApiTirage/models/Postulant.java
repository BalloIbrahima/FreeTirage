package com.freeTirage.apitirage.ApiTirage.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nom;
    String prenom;
    String numero;
    String email;

    @ManyToOne
    @JoinColumn(name = "id_list")
    ListePostulant listePostulant;

    @ManyToMany
    @JoinTable(name = "PopulationRegion", joinColumns = { @JoinColumn(name = "id_postulant") }, inverseJoinColumns = {
            @JoinColumn(name = "id_tirage") })
    List<Tirage> tirages = new ArrayList<>();

}
