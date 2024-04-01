package com.example.loyaltym.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @SequenceGenerator(name="prodotto_id_seq", sequenceName="prodotto_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prodotto_id_seq")
    private Long id;

    private String codice;

    private String descrizione;

    private Double prezzo;

    private Double punti;

}
