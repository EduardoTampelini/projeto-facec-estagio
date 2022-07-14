package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

	List<Produto> findByNomeContaining(String consulta);
}
