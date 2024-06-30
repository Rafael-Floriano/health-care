package br.com.senac.health_care.dto;

import br.com.senac.health_care.domain.Prescricao;

public class PrescricaoDto {
    private long prescricao_id;
    private String descricao;

    public PrescricaoDto() {
    }

    public PrescricaoDto(Prescricao prescricao) {
        this.prescricao_id = prescricao.getPrescricao_id();
        this.descricao = prescricao.getDescricao();
    }

    public PrescricaoDto(long prescricao_id, String descricao) {
        this.prescricao_id = prescricao_id;
        this.descricao = descricao;
    }

    public long getPrescricao_id() {
        return prescricao_id;
    }

    public void setPrescricao_id(long prescricao_id) {
        this.prescricao_id = prescricao_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
