package br.com.senac.health_care.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.senac.health_care.domain.Agendamento;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


    @Query("""
    SELECT a FROM Agendamento a
    WHERE a.paciente.id = :id
    """)
    List<Agendamento> findAllByIdPaciente(Long id);

}
