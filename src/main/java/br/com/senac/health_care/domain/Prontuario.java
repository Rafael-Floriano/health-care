package br.com.senac.health_care.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @Column(name = "id_prontuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    @Column(name = "id_registro_medico")
    private List<RegistroMedico> registroMedicos;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "data_saida", nullable = false)
    private LocalDate dataSaida;

    @Column(name = "convenio")
    private String convenio;

}
