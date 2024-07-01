package br.com.senac.health_care.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaturamentoAgendamentoDto implements Serializable {

    private Long agendamentoId;
    private ProcedimentoDto procedimentoDto;
    private List<MedicamentoDto> medicamentoDtoList;
    private List<MaterialDto> materialDtoList;
    private Double valorTotalFaturamentoAgendamento;

    public void calculaValorTotalFaturamentoAgendamento() {
        valorTotalFaturamentoAgendamento = procedimentoDto.getValor()
                + medicamentoDtoList.stream().mapToDouble(MedicamentoDto::getValor).sum()
                + materialDtoList.stream().mapToDouble(MaterialDto::getValor).sum();
    }

    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }

    public ProcedimentoDto getProcedimentoDto() {
        return procedimentoDto;
    }

    public void setProcedimentoDto(ProcedimentoDto procedimentoDto) {
        this.procedimentoDto = procedimentoDto;
    }

    public List<MedicamentoDto> getMedicamentoDtoList() {
        return medicamentoDtoList;
    }

    public void setMedicamentoDtoList(List<MedicamentoDto> medicamentoDtoList) {
        this.medicamentoDtoList = medicamentoDtoList;
    }

    public List<MaterialDto> getMaterialDtoList() {
        return materialDtoList;
    }

    public void setMaterialDtoList(List<MaterialDto> materialDtoList) {
        this.materialDtoList = materialDtoList;
    }

    public Double getValorTotal() {
        return valorTotalFaturamentoAgendamento;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotalFaturamentoAgendamento = valorTotal;
    }
}
