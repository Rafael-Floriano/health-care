package br.com.senac.health_care.Repository;

import br.com.senac.health_care.domain.RegistroMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMedicoRepository extends JpaRepository<RegistroMedico, Long> {
}
