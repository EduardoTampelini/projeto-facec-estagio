package com.facec.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.facec.model.Cliente;
import com.facec.model.Produto;
import com.facec.model.Venda;
import com.facec.model.Vendedor;

public class VendaDto {

private Long id;
	
	@NotNull(message = "Informe um cliente")
	private Cliente cliente;
	
	@NotNull(message = "Informe um vendedor")
	private Vendedor vendedor;
	
	@NotNull(message = "Informe um produto")
	private Produto produto;
	
	@NotNull(message = "Informe o valor da venda")
    private BigDecimal valor;
	
	
	private String desc;
	
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	public VendaDto() {
		// TODO Auto-generated constructor stub
	}

	public VendaDto(Venda entity) {
		super();
		this.id = entity.getId();
		this.cliente = entity.getCliente();
		this.vendedor = entity.getVendedor();
		this.produto = entity.getProduto();
		this.desc = entity.getDesc();
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public Venda getEntity() {
		return new Venda(id, cliente, vendedor,produto,desc,data,valor);
	}

	
}
