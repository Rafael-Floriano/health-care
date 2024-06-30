package br.com.senac.health_care.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class ProntuarioDto implements Serializable {

    private List<RegistroMedicoDto> registroMedicoDtoList;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String convenio;

}
