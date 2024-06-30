package br.com.senac.health_care.domain;

import br.com.senac.health_care.dto.RegistroMedicoDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "registro_medico")
public class RegistroMedico {

    @Id
    @Column(name = "id_registro_medico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "conteudo")
    private String conteudo;


    public RegistroMedico(RegistroMedicoDto registroMedicoDto) {
        this.conteudo = registroMedicoDto.getConteudo();
    }

    public RegistroMedicoDto toDto() {
        RegistroMedicoDto registroMedicoDto = new RegistroMedicoDto();
        registroMedicoDto.setConteudo(this.conteudo);
        return registroMedicoDto;
    }

}
