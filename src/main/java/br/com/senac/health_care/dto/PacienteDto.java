package br.com.senac.health_care.dto;

import org.springframework.beans.BeanUtils;

import br.com.senac.health_care.domain.Paciente;
import jakarta.persistence.Entity;

public class PacienteDto {
    

    private Long id;
    private String nome;
    private String telefone;
    private String sexo;
    private String cpf;
    private String descrição;
    
    public PacienteDto(Paciente paciente) {
        BeanUtils.copyProperties(paciente, this);
    }

    public PacienteDto(){
            }
    public PacienteDto(Long id, String nome, String telefone, String sexo, String cpf, String descrição) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.cpf = cpf;
        this.descrição = descrição;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    
    
    
}
