package br.com.senac.health_care.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.health_care.Entities.medicamento;
import br.com.senac.health_care.Repository.medicamentoRepository;
import br.com.senac.health_care.dto.medicamentoDto;

@Service
public class medicamentoService {

    @Autowired
    medicamentoRepository repository;

    public String cadastrar(medicamento medicamento) {
        repository.save(medicamento);
        return "Cadastro efetuado com sucesso!";
    }

    public List<medicamentoDto> listar() {
        List<medicamento> medicamentos = repository.findAll();
        return medicamentos.stream().map(x -> new medicamentoDto(x)).collect(Collectors.toList());
    }

}
