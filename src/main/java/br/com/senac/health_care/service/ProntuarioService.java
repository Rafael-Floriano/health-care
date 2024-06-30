package br.com.senac.health_care.service;

import br.com.senac.health_care.domain.Prontuario;
import br.com.senac.health_care.dto.ProntuarioDto;
import br.com.senac.health_care.repository.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;

    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<ProntuarioDto> createProntuario(ProntuarioDto prontuarioDto) {
        Prontuario prontuario = prontuarioRepository.save(new Prontuario(prontuarioDto));
        return ResponseEntity.ok(prontuario.toDto());
    }
}
