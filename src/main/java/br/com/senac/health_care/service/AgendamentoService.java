package br.com.senac.health_care.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.senac.health_care.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.senac.health_care.domain.Agendamento;
import br.com.senac.health_care.dto.AgendamentoDto;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public String cadastrar(Agendamento agendamento) {
        if (agendamento.getDataHora() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data agendamento deve ser informada");
        }

        checaSeJaExisteAgendamentoNoHorario(agendamento.getDataHora());
        repository.save(agendamento);
        return "Cadastro efetuado com sucesso!";
    }

    public void checaSeJaExisteAgendamentoNoHorario(LocalDateTime dataHora) {
        List<Agendamento> agendamentoList = repository.findAllByDataHora(dataHora);
        if (agendamentoList != null && !agendamentoList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um agendamento nesse horário");
        }
    }

    public List<AgendamentoDto> ListarAgendamento() {
        List<Agendamento> agendamentos = repository.findAll();
        return agendamentos.stream().map(x -> new AgendamentoDto(x)).collect(Collectors.toList());
    }

    public ResponseEntity<AgendamentoDto> updateAgendamento(Long agendamento_id, AgendamentoDto agendamentoDto) {
        Agendamento agendamento = repository.findById(agendamento_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "não encontrado"));
        agendamento.setPaciente(agendamentoDto.getPaciente());
        agendamento.setDataHora(agendamentoDto.getDataHora());
        agendamento.setPrescricoes(agendamentoDto.getPrescricoes());
        agendamento.setProcedimento(agendamentoDto.getProcedimento());
        agendamento.setProntuario(agendamentoDto.getProntuario());

        repository.save(agendamento);
        return ResponseEntity.ok(new AgendamentoDto(agendamento));
    }

    public ResponseEntity<String> cancelarAgendamento(Long agendamento_id) {
        repository.deleteById(agendamento_id);
        return ResponseEntity.ok("Agendamento Removido com sucesso");
    }
}
