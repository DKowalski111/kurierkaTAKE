package com.example.take.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "klienci")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_K;

    private String imie;
    private String nazwisko;
    private LocalDate data_ur;
    private String nr_tel;
    private String adres;

}
