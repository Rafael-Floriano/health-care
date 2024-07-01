package br.com.senac.health_care.domain;

import java.time.LocalDateTime;
import java.util.List;

import br.com.senac.health_care.dto.FaturamentoAgendamentoDto;
import br.com.senac.health_care.dto.MedicamentoDto;
import jakarta.persistence.*;

@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agendamento_id;
    @ManyToOne
    private Paciente paciente;
    private LocalDateTime dataHora;
    @OneToOne
    private Prontuario prontuario;
    private String Status;
    @OneToOne
    private Procedimento procedimento;
    @OneToMany
    private List<Prescricao> prescricoes;
    @ManyToMany
    private List<Material> materials;

    public Agendamento() {
    }

    public Agendamento(Long agendamento_id, Paciente paciente, LocalDateTime dataHora, Prontuario prontuario,
            String status, Procedimento procedimento, List<Prescricao> prescricoes) {
        this.agendamento_id = agendamento_id;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.prontuario = prontuario;
        Status = status;
        this.procedimento = procedimento;
        this.prescricoes = prescricoes;
    }

    public FaturamentoAgendamentoDto toFaturamentoAgendamentoDto() {
        FaturamentoAgendamentoDto dto = new FaturamentoAgendamentoDto();
        dto.setAgendamentoId(this.agendamento_id);
        dto.setProcedimentoDto(this.procedimento != null ? this.procedimento.toDto() : null);
        dto.setMedicamentoDtoList(this.prescricoes
                .stream().map(
                        x -> x.getMedicamentos().stream().map(MedicamentoDto::new).toList()
                ).toList().get(0));
        dto.setMaterialDtoList(this.materials.stream().map(Material::toDto).toList());
        dto.calculaValorTotalFaturamentoAgendamento();
        return dto;
    }

    public Long getAgendamento_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(Long agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

}
