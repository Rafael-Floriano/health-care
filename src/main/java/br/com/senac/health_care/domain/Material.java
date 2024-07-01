package br.com.senac.health_care.domain;

import br.com.senac.health_care.dto.MaterialDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material")
public class Material {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;

    public MaterialDto toDto() {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(this.id);
        materialDto.setDescricao(this.descricao);
        materialDto.setValor(this.valor);
        return materialDto;
    }

}
