package com.codeonblue.shop2.validator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.codeonblue.shop2.model.Produto;
import com.codeonblue.shop2.repository.ProdutoRepository;

@Component
public class ProdutoValidator extends LocalValidatorFactoryBean {

	private ProdutoRepository produtoRepository;

	@Resource
	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Produto.class);
	}

	@Override
	public void validate(Object obj, Errors errors, Object... validationHints) {
		super.validate(obj, errors, validationHints);

		if (!errors.hasErrors()) {
			Produto produtoForm = (Produto) obj;
			Produto produto = produtoRepository.findByNomeIgnoreCase(produtoForm
					.getNome());
			if (produto != null  && produtoForm.getId() == null) {
				errors.rejectValue("nome","produto.formulario.nome.nao.e.unico");
			}
		}
	}

}
