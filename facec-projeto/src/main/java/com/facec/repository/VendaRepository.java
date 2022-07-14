package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Cliente;

import com.facec.model.Venda;



public interface VendaRepository extends JpaRepository<Venda, Long>{

	List<Venda> findByCliente(Cliente cliente);
}
