package com.facec.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Venda {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "vendedor_fk")
	private Vendedor vendedor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;
	
	private String desc;
	
	@PastOrPresent(message = "teste")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	@NotNull(message = "A Valor do poduto não pode ser branco")
    private BigDecimal valor;

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Long id, Cliente cliente, Vendedor vendedor, Produto produto, String desc, LocalDate data,BigDecimal valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.produto = produto;
		this.desc=desc;
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
		valor = valor;
	}
	
}
