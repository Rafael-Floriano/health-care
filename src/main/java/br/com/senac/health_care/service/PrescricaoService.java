package br.com.senac.health_care.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.health_care.domain.Prescricao;
import br.com.senac.health_care.repository.PrescricaoRepository;
import br.com.senac.health_care.dto.PrescricaoDto;

@Service
public class PrescricaoService {

    @Autowired
    PrescricaoRepository repository;

    public String cadastrar(Prescricao prescricao) {
        repository.save(prescricao);
        return "prescricao cadastrada com sucesso!";
    }

    public List<PrescricaoDto> listar() {
        List<Prescricao> prescricoes = repository.findAll();
        return prescricoes.stream().map(x -> new PrescricaoDto(x)).collect(Collectors.toList());
    }
}
