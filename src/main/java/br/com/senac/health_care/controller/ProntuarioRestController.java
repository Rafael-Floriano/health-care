package br.com.senac.health_care.controller;

import br.com.senac.health_care.dto.ProntuarioDto;
import br.com.senac.health_care.service.ProntuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prontuario")
public class ProntuarioRestController {

    private final ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<ProntuarioDto> createProntuario(@RequestBody ProntuarioDto prontuarioDto) {
        return prontuarioService.createProntuario(prontuarioDto);
    }

}
