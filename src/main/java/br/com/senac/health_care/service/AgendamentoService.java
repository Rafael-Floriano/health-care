package br.com.senac.health_care.service;

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
        repository.save(agendamento);
        return "Cadastro efetuado com sucesso!";
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
}
