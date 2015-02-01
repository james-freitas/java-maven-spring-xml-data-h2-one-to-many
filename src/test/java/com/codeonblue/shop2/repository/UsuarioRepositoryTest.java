package com.codeonblue.shop2.repository;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codeonblue.shop2.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class UsuarioRepositoryTest {

	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void testaFuncionamentoDoInsertEDaBuscaPorId() {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("james");
		usuario.setSenha("james");
		
		repository.save(usuario);
		
		Usuario dbUsuario = repository.findOne(usuario.getId());
		Assert.assertNotNull(dbUsuario);
		System.out.println(dbUsuario.getLogin());
	}

}
