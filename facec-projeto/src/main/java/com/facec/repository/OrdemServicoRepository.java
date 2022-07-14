package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Cliente;
import com.facec.model.Ordem;
import com.facec.model.Venda;



public interface OrdemServicoRepository extends JpaRepository<Ordem, Long>{

	List<Ordem> findByCliente(Cliente cliente);
}
