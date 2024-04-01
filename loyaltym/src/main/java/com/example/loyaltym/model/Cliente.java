package com.example.loyaltym.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cliente {


    @Id
    @SequenceGenerator(name="cliente_id_seq_gen", sequenceName="cliente_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente_id_seq_gen")
    @Column(name = "id", updatable=false)
    private Integer id;

    private String codice;

    private String nome;

    private String cognome;

    private String email;

    private String citta;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    // @JsonManagedReference
    // @JsonIgnoreProperties({"cliente"})
    private List<Carta> carte = new ArrayList<>();

}
