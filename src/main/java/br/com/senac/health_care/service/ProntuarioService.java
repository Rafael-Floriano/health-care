package br.com.senac.health_care.service;

import br.com.senac.health_care.domain.Prontuario;
import br.com.senac.health_care.domain.RegistroMedico;
import br.com.senac.health_care.dto.ProntuarioDto;
import br.com.senac.health_care.repository.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;

    public ResponseEntity<ProntuarioDto> createProntuario(ProntuarioDto prontuarioDto) {
        Prontuario prontuario = prontuarioRepository.save(new Prontuario(prontuarioDto));
        return ResponseEntity.ok(prontuario.toDto());
    }

    public ResponseEntity<ProntuarioDto> updateProntuario(Long id, ProntuarioDto prontuarioDto) {
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prontuário não encontrado"));

        prontuario.setDataEntrada(prontuarioDto.getDataEntrada());
        prontuario.setDataSaida(prontuarioDto.getDataSaida());
        prontuario.getRegistroMedicos()
                .addAll(prontuarioDto.getRegistroMedicoDtoList().stream().map(RegistroMedico::new).toList());
        prontuario.setConvenio(prontuario.getConvenio());

        prontuarioRepository.save(prontuario);
        return ResponseEntity.ok(prontuario.toDto());
    }

    public ResponseEntity<List<ProntuarioDto>> getAllProntuarios() {
        List<ProntuarioDto> prontuarios = prontuarioRepository.findAll().stream().map(Prontuario::toDto).toList();
        return ResponseEntity.ok(prontuarios);
    }

    public ResponseEntity<String> removeProntuario(Long id) {
        prontuarioRepository.deleteById(id);
        return ResponseEntity.ok("Prontuário removido com sucesso!");
    }
}
