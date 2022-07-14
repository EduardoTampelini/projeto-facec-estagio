package com.facec.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.facec.model.Cliente;
import com.facec.model.Ordem;
import com.facec.model.Produto;
import com.facec.model.Servico;
import com.facec.model.Tecnico;
import com.facec.model.Venda;
import com.facec.model.Vendedor;

public class OrdemDto {

private Long id;
	
	@NotNull(message = "Informe um cliente")
	private Cliente cliente;
	
	@NotNull(message = "Informe um vendedor")
	private Tecnico tecnico;
	
	@NotNull(message = "Informe um produto")
	private Servico servico;
	
	@NotNull(message = "Informe o valor da venda")
    private BigDecimal valor;
	
	
	private String desc;
	
	@NotBlank
	private String temptotal;
	
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	public OrdemDto() {
		// TODO Auto-generated constructor stub
	}

	public OrdemDto(Ordem entity) {
		super();
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.tecnico = entity.getTecnico();
		this.servico = entity.getServico();
		this.desc = entity.getDesc();
		this.temptotal = entity.getTemptotal();
		this.data = entity.getData();
		this.valor = entity.getValor();
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
		this.valor = valor;
	}

	public Ordem getEntity() {
		return new Ordem(id, cliente, tecnico,servico,desc,temptotal,data,valor);
	}

	
}
