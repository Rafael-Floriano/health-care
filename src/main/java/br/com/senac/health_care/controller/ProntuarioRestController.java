package br.com.senac.health_care.controller;

import br.com.senac.health_care.dto.ProntuarioDto;
import br.com.senac.health_care.service.ProntuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prontuario")
@Tag(name = "Prontuario Rest Controller", description = "Controller responsável pelas seguintes funções: adicionar, atualizar, remover e listar registros médicos;")
public class ProntuarioRestController {

    private final ProntuarioService prontuarioService;

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo prontuário")
    public ResponseEntity<ProntuarioDto> createProntuario(@RequestBody ProntuarioDto prontuarioDto) {
        return prontuarioService.createProntuario(prontuarioDto);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Faz a atualização de um prontuário já existente")
    public ResponseEntity<ProntuarioDto> updateProntuario(@PathVariable("id") Long id,
            @RequestBody ProntuarioDto prontuarioDto) {
        return prontuarioService.updateProntuario(id, prontuarioDto);
    }

    @GetMapping
    @Operation(summary = "Busca por todos os prontuários")
    public ResponseEntity<List<ProntuarioDto>> getAllProntuarios() {
        return prontuarioService.getAllProntuarios();
    }

    @DeleteMapping
    @Operation(summary = "Delete prontuários pelo id")
    public ResponseEntity<String> removeProntuario(@RequestParam("id") Long id) {
        return prontuarioService.removeProntuario(id);
    }

}
