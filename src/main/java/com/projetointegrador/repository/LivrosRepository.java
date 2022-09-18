package com.projetointegrador.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Livros;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long>{
	
	public List<Livros>findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
	public Optional<Livros>findByTitulo(String titulo);
	
}