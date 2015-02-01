package com.codeonblue.shop2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeonblue.shop2.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Produto findByNomeIgnoreCase(String nome);

}
