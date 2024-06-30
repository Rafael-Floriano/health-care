package br.com.senac.health_care.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "registro_medico")
public class RegistroMedico {

    @Id
    @Column(name = "id_registro_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudo")
    private String conteudo;



}
