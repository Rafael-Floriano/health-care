package br.com.senac.health_care.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.health_care.Entities.prescricao;
import br.com.senac.health_care.Repository.prescricaoRepository;
import br.com.senac.health_care.dto.prescricaoDto;

@Service
public class prescricaoService {

    @Autowired
    prescricaoRepository repository;

    public String cadastrar(prescricao prescricao) {
        repository.save(prescricao);
        return "prescricao cadastrada com sucesso!";
    }

    public List<prescricaoDto> listar() {
        List<prescricao> prescricoes = repository.findAll();
        return prescricoes.stream().map(x -> new prescricaoDto(x)).collect(Collectors.toList());
    }
}
