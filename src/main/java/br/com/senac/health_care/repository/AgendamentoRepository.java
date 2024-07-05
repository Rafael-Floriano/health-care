package br.com.senac.health_care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.health_care.domain.Agendamento;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("""
            SELECT a FROM Agendamento a
            WHERE a.paciente.id = :id
            """)
    List<Agendamento> findAllByIdPaciente(Long id);

    List<Agendamento> findAllByDataHora(LocalDateTime dataHora);

}
