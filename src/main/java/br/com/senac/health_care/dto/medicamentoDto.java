package br.com.senac.health_care.dto;

import br.com.senac.health_care.Entities.medicamento;

public class medicamentoDto {
    private long medicamento_id;
    private String nome;
    private double valor;

    public medicamentoDto() {
    }

    public medicamentoDto(medicamento medicamento) {
        this.medicamento_id = medicamento.getMedicamento_id();
        this.nome = medicamento.getNome();
        this.valor = medicamento.getValor();
    }

    public medicamentoDto(long medicamento_id, String nome, double valor) {
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
