package br.com.senac.health_care.dto;

import br.com.senac.health_care.domain.Medicamento;

public class MedicamentoDto {
    private long medicamento_id;
    private String nome;
    private double valor;

    public MedicamentoDto() {
    }

    public MedicamentoDto(Medicamento medicamento) {
        this.medicamento_id = medicamento.getMedicamento_id();
        this.nome = medicamento.getNome();
        this.valor = medicamento.getValor();
    }

    public MedicamentoDto(long medicamento_id, String nome, double valor) {
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
