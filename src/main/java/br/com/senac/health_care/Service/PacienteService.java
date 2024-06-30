package br.com.senac.health_care.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.senac.health_care.Repository.PacienteRepository;
import br.com.senac.health_care.dto.PacienteDto;
import br.com.senac.health_care.entities.Paciente;

@Service
public class PacienteService {
 @Autowired 
    private PacienteRepository pacienteRepository;

    
    public ResponseEntity<PacienteDto> cadastraPaciente( Paciente paciente ){
       
        Paciente pacienteAdicionado = pacienteRepository.save(paciente);
        return ResponseEntity.ok(new PacienteDto(pacienteAdicionado));
    }
    
    public ResponseEntity<Object>listaPaciente(Long id){
        
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if(paciente.isPresent()){

        return ResponseEntity.ok(new PacienteDto(paciente.get()));
        
        } 

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        
    }
    
    
    public ResponseEntity<String> delete(Long id){
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Paciente deletado com sucesso");
    }
}
