package com.freeTirage.apitirage.ApiTirage.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class PostulantTrie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tirage")
    Tirage tirage;

    @ManyToOne
    Postulant postulants;
}
