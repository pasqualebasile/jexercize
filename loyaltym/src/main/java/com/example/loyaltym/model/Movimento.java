package com.example.loyaltym.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movimento")
public class Movimento {

    @Id
    @SequenceGenerator(name="movimento_id_seq", sequenceName="movimento_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="movimento_id_seq")
    private Long id;

    private LocalDateTime dataora;

    private Integer quantita;

    private Double importo;

    private Double sconto;

    private Double totale;

    private Integer mtipo;

    private Double punti;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Cliente"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "carta_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Carta"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Carta carta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "prodotto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Prodotto"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Prodotto prodotto;

}
