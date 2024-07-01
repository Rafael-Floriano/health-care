package br.com.senac.health_care.domain;

import br.com.senac.health_care.dto.ProcedimentoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "procedimento")
public class Procedimento {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;

    public ProcedimentoDto toDto() {
        ProcedimentoDto procedimentoDto = new ProcedimentoDto();
        procedimentoDto.setId(this.id);
        procedimentoDto.setDescricao(this.descricao);
        procedimentoDto.setValor(this.valor);
        return procedimentoDto;
    }
}
