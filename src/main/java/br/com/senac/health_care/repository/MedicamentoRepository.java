package br.com.senac.health_care.repository;

import org.springframework.stereotype.Repository;

import br.com.senac.health_care.domain.Medicamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}