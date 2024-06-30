package br.com.senac.health_care.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prescricao_id;
    private String descricao;

    @ManyToMany(mappedBy = "prescricao")
    private List<medicamento> medicamentos;

    public prescricao() {
    }

    public prescricao(long prescricao_id, String descricao, List<medicamento> medicamentos) {
        this.prescricao_id = prescricao_id;
        this.descricao = descricao;
        this.medicamentos = medicamentos;
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

    public List<medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

}
