package br.com.senac.health_care.Repository;

import org.springframework.stereotype.Repository;

import br.com.senac.health_care.Entities.medicamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface medicamentoRepository extends JpaRepository<medicamento, Long> {

}