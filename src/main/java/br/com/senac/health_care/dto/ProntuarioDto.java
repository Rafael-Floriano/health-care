package br.com.senac.health_care.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProntuarioDto implements Serializable {

    private List<RegistroMedicoDto> registroMedicoDtoList;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String convenio;

    public List<RegistroMedicoDto> getRegistroMedicoDtoList() {
        return registroMedicoDtoList;
    }

    public void setRegistroMedicoDtoList(List<RegistroMedicoDto> registroMedicoDtoList) {
        this.registroMedicoDtoList = registroMedicoDtoList;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
}
