package br.com.senac.health_care.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProcedimentoDto implements Serializable {

    private Long id;
    private String descricao;
    private Double valor;

}
