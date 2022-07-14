package com.facec.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotBlank(message = "A nome do poduto não pode estar em branco")
    private String nome;
	
	
    private String tempesti;
	
    @NotNull(message = "A Valor do poduto não pode ser branco")
    private BigDecimal Valor;
    
    @NotNull(message = "O telefone do vendedor não pode ser branco")
    private Status status;

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	public String getTempesti() {
		return tempesti;
	}
	public void setTempesti(String tempesti) {
		this.tempesti = tempesti;
	}
	public BigDecimal getValor() {
		return Valor;
	}
	public void setValor(BigDecimal valor) {
		Valor = valor;
	}
    
    
}
