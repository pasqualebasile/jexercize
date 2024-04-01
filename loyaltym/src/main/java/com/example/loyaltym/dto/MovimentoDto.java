package com.example.loyaltym.dto;

import com.example.loyaltym.model.Carta;
import com.example.loyaltym.model.Cliente;
import com.example.loyaltym.model.Prodotto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Data
public class MovimentoDto {

    private LocalDateTime dataora;

    private String numeroCarta;

    private String codiceProdotto;

    private Integer quantita;

    private Double importo;

    private Double sconto;

    private Double totale;

    private Integer tipo;

    private Double punti;


}
