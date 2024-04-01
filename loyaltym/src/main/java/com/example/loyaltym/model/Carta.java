package com.example.loyaltym.model;
import com.example.loyaltym.views.Views;
import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "carta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Carta {

    @Id
    @SequenceGenerator(name="carta_id_seq", sequenceName="carta_id_seq", allocationSize=1, initialValue = 1001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carta_id_seq")
    private Long id;

    private String numero;

    /**
     * 0: creata
     * 1: attiva
     * 2: blacklist
     * 3: eliminata
     */
    private Integer status;

    private LocalDate data_creazione;

    private LocalDate data_emissione;

    private LocalDate data_scadenza;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cliente_id", nullable = true, foreignKey = @ForeignKey(name = "FK_Card"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    // @JsonIgnore
    // @JsonView(Views.CartaConCliente.class)
    // @JsonBackReference // Evita il loop infinito
    // @JsonIgnoreProperties({"carte"})
    private Cliente cliente;

    private Long punti;
}
