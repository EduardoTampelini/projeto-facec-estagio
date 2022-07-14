package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.facec.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor,Long>{

	List<Vendedor> findByNomeContaining(String consulta);
}
