package br.com.senac.health_care.controller;

import java.util.List;

import br.com.senac.health_care.service.PrescricaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.domain.Prescricao;
import br.com.senac.health_care.dto.PrescricaoDto;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/prescricao")
@Tag(name = "Prescrição Rest Controller", description = "Controller responsável pelas seguintes funções: Criar, atualizar, cancelar e listar prescrições;")
public class PrescricaoController {

    @Autowired
    private PrescricaoService service;

    @GetMapping("/cadastrar")
    @Operation(summary = "Cria uma nova prescrição")
    public ResponseEntity<String> cadastrar(Prescricao prescricao) {
        return new ResponseEntity<>(service.cadastrar(prescricao), HttpStatus.OK);
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista as prescrição existentes")
    public ResponseEntity<List<PrescricaoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/editar/{id}")
    @Operation(summary = "Faz atualização das prescricoes")
    public ResponseEntity<PrescricaoDto> updatePrescricao(@PathVariable("prescricao_id") Long prescricao_id,
            @RequestBody PrescricaoDto prescricaoDto) {

        return service.updatePrescricao(prescricao_id, prescricaoDto);
    }

    @DeleteMapping
    @Operation(summary = "Delete prescrição via id")
    public ResponseEntity<String> removeProntuario(@RequestParam("prescricao_id") Long prescricao_id) {
        return service.removePrescricao(prescricao_id);
    }

}
