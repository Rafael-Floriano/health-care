package br.com.senac.health_care.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "data_saida", nullable = false)
    private LocalDate dataSaida;

    @Column(name = "convenio")
    private String convenio;

}
