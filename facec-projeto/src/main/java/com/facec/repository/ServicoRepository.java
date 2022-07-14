package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Produto;
import com.facec.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Long>{

	List<Servico> findByNomeContaining(String consulta);
}
