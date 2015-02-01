package com.codeonblue.shop2.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeonblue.shop2.model.Categoria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class CategoriaRepositoryTest {

	@Autowired
	CategoriaRepository repository;
	
	@Test
	public void test() {
		Categoria categoria = new Categoria();
		categoria.setNome("Esportes");

		repository.save(categoria);
		
		Categoria dbCategoria = repository.findOne(categoria.getId());
		Assert.assertNotNull(dbCategoria);
		System.out.println(dbCategoria.getNome());
		
	}
	
}
