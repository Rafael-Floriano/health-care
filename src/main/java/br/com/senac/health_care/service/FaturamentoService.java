package br.com.senac.health_care.service;

import br.com.senac.health_care.domain.Agendamento;
import br.com.senac.health_care.dto.FaturamentoDto;
import br.com.senac.health_care.dto.PacienteDto;
import br.com.senac.health_care.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public ResponseEntity<FaturamentoDto> getFaturamentoPaciente(Long idPaciente) {
        List<Agendamento> agendamentoList = agendamentoRepository.findAllByIdPaciente(idPaciente);

        if (agendamentoList.isEmpty()) {
            return ResponseEntity.ok(null);
        }

        FaturamentoDto faturamentoDto = new FaturamentoDto();
        faturamentoDto.setFaturamentoAgendamentoDtoList(agendamentoList.stream().map(Agendamento::toFaturamentoAgendamentoDto).toList());
        faturamentoDto.setPacienteDto(new PacienteDto(agendamentoList.get(0).getPaciente()));
        faturamentoDto.calculaTotalFaturamento();

        return ResponseEntity.ok(faturamentoDto);
    }

}
