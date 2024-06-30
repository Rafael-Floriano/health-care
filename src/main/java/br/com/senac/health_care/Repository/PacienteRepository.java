package br.com.senac.health_care.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.health_care.entities.Paciente;

@Repository
    public interface PacienteRepository extends JpaRepository<Paciente, Long> {
        //List<Paciente> findAllBy(String paciente, Long id); 
    
        
}
