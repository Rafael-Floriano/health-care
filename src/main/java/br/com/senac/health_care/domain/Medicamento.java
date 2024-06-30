package br.com.senac.health_care.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Medicamento {
    @Id
    private long medicamento_id;
    private String nome;
    private double valor;

    public Medicamento() {
    }

    public Medicamento(long medicamento_id, String nome, double valor) {
        this.medicamento_id = medicamento_id;
        this.nome = nome;
        this.valor = valor;
    }

    public long getMedicamento_id() {
        return medicamento_id;
    }

    public void setMedicamento_id(long medicamento_id) {
        this.medicamento_id = medicamento_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
