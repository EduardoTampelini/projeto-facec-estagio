package com.facec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Tecnico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Size(min = 3, max = 50,message = "Nome com numero de caracteres invalidos")
	@NotBlank(message = "O nome do vendedor não pode ser branco")
    private String nome;
	@NotBlank(message = "O cpf do vendedor não pode ser branco")
	@CPF(message = "CPF Invalido!")
    private String cpf;
	
	@Size(min = 11, max = 20,message = "Telefone com numero de caracteres invalidos")
	@NotBlank(message = "O telefone do vendedor não pode ser branco")
    private String telefone;
	@NotNull(message = "O telefone do vendedor não pode ser branco")
    private Status status;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}
