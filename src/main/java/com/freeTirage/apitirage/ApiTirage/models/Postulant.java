package com.freeTirage.apitirage.ApiTirage.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "postulants")
    List<ListePostulant> listePostulant = new ArrayList<>();

}
