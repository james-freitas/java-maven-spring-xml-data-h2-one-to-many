package com.codeonblue.shop2.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.codeonblue.shop2.model.Categoria;
import com.codeonblue.shop2.repository.CategoriaRepository;

@Component
public class CategoriaValidator extends LocalValidatorFactoryBean{

	private CategoriaRepository categoriaRepository;
	
	@Resource
	public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Categoria.class);
	}
	
	@Override
	public void validate(Object obj, Errors errors,
			Object... validationHints) {
		super.validate(obj, errors, validationHints);
		
		if(!errors.hasErrors()) {
			Categoria categoriaForm = (Categoria)obj;
			Categoria categoria = categoriaRepository.findByNomeIgnoreCase(categoriaForm.getNome());
			if(categoria != null && categoriaForm.getId() == null) {
				errors.rejectValue("nome", "categoria.formulario.nome.nao.e.unico");
			}
		}
	}
}
