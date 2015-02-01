package com.codeonblue.shop2.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codeonblue.shop2.model.Categoria;
import com.codeonblue.shop2.model.Produto;
import com.codeonblue.shop2.repository.CategoriaRepository;
import com.codeonblue.shop2.repository.ProdutoRepository;

@Controller
public class LoginController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping("/welcome")
	public String efetuaLogin() {
		populaCategorias();
		populaProdutos();
		return "welcome";
	}

	@Transactional
	private void populaProdutos() {
		List<Produto> produtos = produtoRepository.findAll();

		if(produtos.isEmpty()) {
			
			Categoria categoria1 = categoriaRepository.findOne(1);
			
			Produto produto1 = new Produto();
			produto1.setNome("A volta dos que nao foram");
			produto1.setDescricao("Detalhes sobre o livro");
			produto1.setPreco(new BigDecimal("50.0"));
			produto1.setCategoria(categoria1);
			produtoRepository.save(produto1);

			Produto produto2 = new Produto();
			produto2.setNome("As trancas do careca");
			produto2.setDescricao("Detalhes sobre o livro");
			produto2.setPreco(new BigDecimal("60.0"));
			produto2.setCategoria(categoria1);
			produtoRepository.save(produto2);

			Produto produto3 = new Produto();
			produto3.setNome("O pistoleiro maneta");
			produto3.setDescricao("Detalhes sobre o livro");
			produto3.setPreco(new BigDecimal("30.0"));
			produto3.setCategoria(categoria1);
			produtoRepository.save(produto3);

			
		}
	}

	@Transactional	
	private void populaCategorias() {
		List<Categoria> categorias = categoriaRepository.findAll();

		if(categorias.isEmpty()) {
			Categoria categoria1 = new Categoria();
			categoria1.setNome("Livros");
			categoriaRepository.save(categoria1);

			Categoria categoria2 = new Categoria();
			categoria2.setNome("DVDs e Blu-Ray");
			categoriaRepository.save(categoria2);

			Categoria categoria3 = new Categoria();
			categoria3.setNome("Games");
			categoriaRepository.save(categoria3);
		
		}
	}

	
	
}
