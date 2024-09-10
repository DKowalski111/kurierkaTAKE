package com.example.take.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "przystanek")
public class Przystanek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_PR;

    private int dystans;
    private LocalTime czas;
    private String adres_pocz;
    private String adres_kon;
}
