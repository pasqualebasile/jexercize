package com.example.loyaltym.dto;

import lombok.Data;

@Data
public class GeneratoreScontrino {
    private String carta;
    private Integer transazioni;
    private Integer reso;
    private Integer punti;
}
