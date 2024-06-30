package br.com.senac.health_care.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.health_care.Entities.prescricao;
import br.com.senac.health_care.Service.prescricaoService;
import br.com.senac.health_care.dto.prescricaoDto;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/prescricao")
public class prescricaoController {

    @Autowired
    prescricaoService service;

    @GetMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(prescricao prescricao) {
        return new ResponseEntity<>(service.cadastrar(prescricao), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<prescricaoDto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

}
