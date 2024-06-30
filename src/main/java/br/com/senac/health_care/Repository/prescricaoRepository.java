package br.com.senac.health_care.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.health_care.Entities.prescricao;

@Repository
public interface prescricaoRepository extends JpaRepository<prescricao, Long> {

}