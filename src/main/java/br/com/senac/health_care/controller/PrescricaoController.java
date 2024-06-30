package br.com.senac.health_care.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.domain.Prescricao;
import br.com.senac.health_care.service.PrescricaoService;
import br.com.senac.health_care.dto.PrescricaoDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/prescricao")
@Tag(name = "Prescrição Rest Controller", description = "Controller responsável pelas seguintes funções: Criar, atualizar, cancelar e listar prescrições;")
public class PrescricaoController {

    @Autowired
    PrescricaoService service;

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

}
