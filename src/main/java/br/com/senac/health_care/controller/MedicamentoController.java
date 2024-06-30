package br.com.senac.health_care.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.domain.Medicamento;
import br.com.senac.health_care.service.MedicamentoService;
import br.com.senac.health_care.dto.MedicamentoDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/medicamento")
@Tag(name = "Medicamento Rest Controller", description = "Controller responsável pelas seguintes funções: Criar e listar medicamentos;")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    @GetMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(Medicamento medicamento) {
        return new ResponseEntity<>(service.cadastrar(medicamento), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MedicamentoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

}
