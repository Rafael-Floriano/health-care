package br.com.senac.health_care.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.Entities.medicamento;
import br.com.senac.health_care.Service.medicamentoService;
import br.com.senac.health_care.dto.medicamentoDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/medicamento")
public class medicamentoController {

    @Autowired
    medicamentoService service;

    @GetMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(medicamento medicamento) {
        return new ResponseEntity<>(service.cadastrar(medicamento), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<medicamentoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

}
