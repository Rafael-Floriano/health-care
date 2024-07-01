package br.com.senac.health_care.controller;

import java.util.List;

import br.com.senac.health_care.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.domain.Agendamento;
import br.com.senac.health_care.dto.AgendamentoDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService service;

    @GetMapping("/cadastro")
    public ResponseEntity<String> cadastrar(Agendamento agendamento) {
        return new ResponseEntity<>(service.cadastrar(agendamento), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AgendamentoDto>> listar() {
        return ResponseEntity.ok(service.ListarAgendamento());
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<AgendamentoDto> editarAgendamento(@PathVariable("agendamento_id") Long agendamento_id,
            @RequestBody AgendamentoDto agendamentoDto) {

        return service.updateAgendamento(agendamento_id, agendamentoDto);
    }

}
