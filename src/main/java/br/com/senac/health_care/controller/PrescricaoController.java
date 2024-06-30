package br.com.senac.health_care.controller;

import java.util.List;

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
public class PrescricaoController {

    @Autowired
    PrescricaoService service;

    @GetMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(Prescricao prescricao) {
        return new ResponseEntity<>(service.cadastrar(prescricao), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PrescricaoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

}
