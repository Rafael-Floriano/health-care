package br.com.senac.health_care.dto;

import br.com.senac.health_care.Entities.prescricao;

public class prescricaoDto {
    private long prescricao_id;
    private String descricao;

    public prescricaoDto() {
    }

    public prescricaoDto(prescricao prescricao) {
        this.prescricao_id = prescricao.getPrescricao_id();
        this.descricao = prescricao.getDescricao();
    }

    public prescricaoDto(long prescricao_id, String descricao) {
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
