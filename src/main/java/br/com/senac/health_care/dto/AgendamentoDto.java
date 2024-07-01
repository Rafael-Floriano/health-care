package br.com.senac.health_care.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.senac.health_care.domain.Agendamento;
import br.com.senac.health_care.domain.Paciente;
import br.com.senac.health_care.domain.Prescricao;
import br.com.senac.health_care.domain.Procedimento;
import br.com.senac.health_care.domain.Prontuario;

public class AgendamentoDto {
    private long agendamento_id;
    private Paciente paciente;
    private LocalDateTime dataHora;
    private Prontuario prontuario;
    private String status;
    private Procedimento procedimento;
    private List<Prescricao> prescricoes;

    public AgendamentoDto() {
    }

    public AgendamentoDto(Agendamento agendamento) {
        this.agendamento_id = agendamento.getAgendamento_id();
    }

    public AgendamentoDto(long agendamento_id, Paciente paciente, LocalDateTime dataHora, Prontuario prontuario,
            String status,
            Procedimento procedimento, List<Prescricao> prescricoes) {
        this.agendamento_id = agendamento_id;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.prontuario = prontuario;
        this.status = status;
        this.procedimento = procedimento;
        this.prescricoes = prescricoes;
    }

    public long getId() {
        return agendamento_id;
    }

    public void setId(long agendamento_id) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
