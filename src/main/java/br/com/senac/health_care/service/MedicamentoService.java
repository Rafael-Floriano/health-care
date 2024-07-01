package br.com.senac.health_care.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.senac.health_care.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.health_care.domain.Medicamento;
import br.com.senac.health_care.dto.MedicamentoDto;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    public String cadastrar(Medicamento medicamento) {
        repository.save(medicamento);
        return "Cadastro efetuado com sucesso!";
    }

    public List<MedicamentoDto> listar() {
        List<Medicamento> Medicamentos = repository.findAll();
        return Medicamentos.stream().map(x -> new MedicamentoDto(x)).collect(Collectors.toList());
    }

}
