package br.com.senac.health_care.controller;

import br.com.senac.health_care.dto.FaturamentoDto;
import br.com.senac.health_care.service.FaturamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faturamento")
public class FaturamentoController {

    @Autowired
    private FaturamentoService faturamentoService;

    @GetMapping("/paciente/{id}")
    public ResponseEntity<FaturamentoDto> getfaturamentoById(@PathVariable("id") Long id) {
        return faturamentoService.getFaturamentoPaciente(id);
    }

}
