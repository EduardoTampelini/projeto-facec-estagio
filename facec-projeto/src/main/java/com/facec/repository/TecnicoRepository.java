package com.facec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facec.model.Tecnico;


public interface TecnicoRepository extends JpaRepository<Tecnico,Long>{

	List<Tecnico> findByNomeContaining(String consulta);
}
