package br.com.senac.health_care.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaturamentoDto implements Serializable {

    private PacienteDto pacienteDto;
    private List<FaturamentoAgendamentoDto> faturamentoAgendamentoDtoList;
    private Double totalFaturamento;

    public void calculaTotalFaturamento() {
        totalFaturamento = faturamentoAgendamentoDtoList.stream().mapToDouble(FaturamentoAgendamentoDto::getValorTotal).sum();
    }

    public PacienteDto getPacienteDto() {
        return pacienteDto;
    }

    public void setPacienteDto(PacienteDto pacienteDto) {
        this.pacienteDto = pacienteDto;
    }

    public List<FaturamentoAgendamentoDto> getFaturamentoAgendamentoDtoList() {
        return faturamentoAgendamentoDtoList;
    }

    public void setFaturamentoAgendamentoDtoList(List<FaturamentoAgendamentoDto> faturamentoAgendamentoDtoList) {
        this.faturamentoAgendamentoDtoList = faturamentoAgendamentoDtoList;
    }

    public Double getTotalFaturamento() {
        return totalFaturamento;
    }

    public void setTotalFaturamento(Double totalFaturamento) {
        totalFaturamento = totalFaturamento;
    }
}
