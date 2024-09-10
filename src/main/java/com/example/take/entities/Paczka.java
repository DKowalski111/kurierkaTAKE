package com.example.take.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "paczki")
public class Paczka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_P;

    private String miejsce_nad;
    private String miejsce_dost;
    private String data_nad;
    private String status;
    private String rozmiar;
    private double waga;

    @ManyToOne
    @JoinColumn(name = "id_K")
    private Klient klient;
}
