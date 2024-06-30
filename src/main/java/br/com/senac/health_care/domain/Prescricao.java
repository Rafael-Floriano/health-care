package br.com.senac.health_care.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prescricao_id;
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Medicamento> medicamentos;

    public Prescricao() {
    }

    public Prescricao(long prescricao_id, String descricao, List<Medicamento> Medicamentos) {
        this.prescricao_id = prescricao_id;
        this.descricao = descricao;
        this.medicamentos = Medicamentos;
    }

    public long getPrescricao_id() {
        return prescricao_id;
    }

    public void setDescricao_id(long prescricao_id) {
        this.prescricao_id = prescricao_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> Medicamentos) {
        this.medicamentos = Medicamentos;
    }

}
