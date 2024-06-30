package br.com.senac.health_care.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.Service.PacienteService;
import br.com.senac.health_care.dto.PacienteDto;
import br.com.senac.health_care.domain.Paciente;

@RestController
@RequestMapping("/paciente")
@Tag(name = "Paciente Rest Controller", description = "Controller responsável pelas seguintes funções: Registrar, atualizar, remover e listar pacientes;")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PacienteDto> cadastroPaciente(@RequestBody Paciente paciente) {
        return pacienteService.cadastraPaciente(paciente);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listaPaciente(@PathVariable("id") Long id) {

        return pacienteService.listaPaciente(id);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> removePaciente(@PathVariable("id") Long id) {

        return pacienteService.delete(id);
    }

}
