package com.example.take.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "trasa")
public class Trasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_T;

    private int dystans;
    private LocalTime czas;

    @OneToMany
    @JoinColumn(name = "id_T")
    private List<Przystanek> lista_przystankow;
}
