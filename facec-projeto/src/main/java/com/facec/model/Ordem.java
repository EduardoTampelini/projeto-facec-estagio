package com.facec.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Ordem {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "tecnico_fk")
	private Tecnico tecnico;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "servico_fk")
	private Servico servico;
	
	private String desc;
	
	@NotBlank
	private String temptotal;
	
    @PastOrPresent(message = "teste")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@NotNull(message = "A Valor do poduto não pode ser branco")
    private BigDecimal valor;

	public Ordem() {
		// TODO Auto-generated constructor stub
	}

	public Ordem(Long id, Cliente cliente, Tecnico tecnico, Servico servico, String desc,String temptotal, LocalDate data,BigDecimal valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tecnico = tecnico;
		this.servico = servico;
		this.desc = desc;
		this.temptotal = temptotal;
		this.data=data;
		this.valor=valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getTemptotal() {
		return temptotal;
	}

	public void setTemptotal(String temptotal) {
		this.temptotal = temptotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		valor = valor;
	}
	
}
