package br.com.senac.health_care.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.senac.health_care.repository.PrescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.senac.health_care.domain.Prescricao;
import br.com.senac.health_care.dto.PrescricaoDto;

@Service
public class PrescricaoService {

    @Autowired
    private PrescricaoRepository repository;

    public String cadastrar(Prescricao prescricao) {
        repository.save(prescricao);
        return "prescricao cadastrada com sucesso!";
    }

    public List<PrescricaoDto> listar() {
        List<Prescricao> prescricoes = repository.findAll();
        return prescricoes.stream().map(x -> new PrescricaoDto(x)).collect(Collectors.toList());
    }

    public ResponseEntity<PrescricaoDto> updatePrescricao(Long prescricao_id, PrescricaoDto prescricaoDto) {
        Prescricao prescricao = repository.findById(prescricao_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        prescricao.setDescricao(prescricaoDto.getDescricao());

        repository.save(prescricao);
        return ResponseEntity.ok(new PrescricaoDto(prescricao));
    }

    public ResponseEntity<String> removePrescricao(Long prescricao_id) {
        repository.deleteById(prescricao_id);
        return ResponseEntity.ok("Prescrição removido");
    }
}
