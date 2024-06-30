package br.com.senac.health_care.domain;

import br.com.senac.health_care.dto.ProntuarioDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @Column(name = "id_prontuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Column(name = "id_registro_medico")
    private List<RegistroMedico> registroMedicos;

    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    @Column(name = "data_saida", nullable = false)
    private LocalDate dataSaida;

    @Column(name = "convenio")
    private String convenio;

    public Prontuario(ProntuarioDto prontuarioDto) {
        this.registroMedicos = prontuarioDto.getRegistroMedicoDtoList().stream().map(RegistroMedico::new).toList();
        this.dataEntrada = prontuarioDto.getDataEntrada();
        this.dataSaida = prontuarioDto.getDataSaida();
        this.convenio = prontuarioDto.getConvenio();
    }

    public ProntuarioDto toDto() {
        ProntuarioDto prontuarioDto = new ProntuarioDto();
        prontuarioDto.setDataEntrada(this.dataEntrada);
        prontuarioDto.setDataSaida(this.dataSaida);
        prontuarioDto.setConvenio(this.convenio);
        prontuarioDto.setRegistroMedicoDtoList(
                this.registroMedicos != null ? this.registroMedicos.stream().map(RegistroMedico::toDto).toList()
                        : null);
        return prontuarioDto;
    }

}
