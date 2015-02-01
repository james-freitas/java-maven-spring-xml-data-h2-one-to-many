package com.codeonblue.shop2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codeonblue.shop2.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Categoria findByNomeIgnoreCase(String nome);

	List<Categoria> findAll();
	
	@Query(value = "select c from Categoria c order by c.nome")
	List<Categoria> findAllOrderByNome();

}
