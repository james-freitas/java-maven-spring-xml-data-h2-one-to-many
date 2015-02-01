package com.codeonblue.shop2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeonblue.shop2.model.Categoria;
import com.codeonblue.shop2.repository.CategoriaRepository;
import com.codeonblue.shop2.validator.CategoriaValidator;

@Controller
public class CategoriaController {

	private CategoriaRepository repository;
	private CategoriaValidator categoriaValidator;
	

	@Autowired
	public CategoriaController(CategoriaRepository repository,
			CategoriaValidator categoriaValidator) {
		this.repository = repository;
		this.categoriaValidator = categoriaValidator;
	}

	@InitBinder("categoria")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(categoriaValidator);
	}
	
	@RequestMapping(value = "categorias")
	public String lista(Model model) {
		model.addAttribute("categorias", repository.findAll());
		return "categoria/lista";
	}
	
	@RequestMapping(value = "/novaCategoria")
	public String form(Model model) {
		model.addAttribute(new Categoria());
		return "categoria/formulario";
	}
	
	@RequestMapping("/adicionaCategoria")
	@Transactional
	public String adiciona( @Valid Categoria categoria, BindingResult result){

		if(result.hasErrors()) {
			return "categoria/formulario";
		}
		
		repository.save(categoria);
		return "redirect:categorias";
	}

	
	@RequestMapping(value = "editaCategoria")
	public String editaCategoria(@Valid Categoria categoria, BindingResult result){
		if(result.hasErrors()) {
			return "categoria/mostra";
		}
		repository.save(categoria);
		return "redirect:categorias";
	}
	
	@RequestMapping(value = "removeCategoria", method=RequestMethod.GET)
	@Transactional
	public String removeCategoria(Categoria categoria) {
		repository.delete(categoria);
		return "redirect:categorias";
	}

	@RequestMapping(value = "mostraCategoria")
	public String mostraCategoria(Integer id, Model model) {
		model.addAttribute("categoria", repository.findOne(id));
		return "categoria/mostra";
	}
	

}
