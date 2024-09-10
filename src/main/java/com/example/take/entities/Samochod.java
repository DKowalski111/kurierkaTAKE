package com.example.take.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "samochody")
public class Samochod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_S;

    private String marka;
    private String model;
    private int rok_produkcji;
    private String numer_rej;
    private int przebieg;
    private int ilosc_paczek;
    private boolean dostepnosc;
}
