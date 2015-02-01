package com.codeonblue.shop2.repository;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeonblue.shop2.model.Categoria;
import com.codeonblue.shop2.model.Produto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/application-context.xml")
public class ProdutoRepositoryTest {

	@Autowired
	ProdutoRepository repositoryProduto;

	@Autowired
	CategoriaRepository repositoryCategoria;

	@Test
	public void testaFuncionamentoDoInsertEDaBuscaPorId() {

		Categoria categoria = new Categoria();
		categoria.setNome("Esportes");

		repositoryCategoria.save(categoria);

		Categoria categoriaCriada = repositoryCategoria.findOne(1);

		Produto produto = new Produto();

		produto.setNome("Bola de futebol");
		produto.setDescricao("Bola de futebol do flamengo");
		produto.setPreco(new BigDecimal("100.0"));
		produto.setCategoria(categoriaCriada);

		repositoryProduto.save(produto);

		Produto produtoCriado = repositoryProduto.findOne(produto.getId());

		Assert.assertNotNull(produtoCriado);
		System.out.println(produtoCriado.getId() + " - "
				+ produtoCriado.getNome() + " - "
				+ produto.getCategoria().getNome());

	}

}
