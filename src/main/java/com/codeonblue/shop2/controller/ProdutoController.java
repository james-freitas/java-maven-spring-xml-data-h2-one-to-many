package com.codeonblue.shop2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeonblue.shop2.model.Categoria;
import com.codeonblue.shop2.model.Produto;
import com.codeonblue.shop2.repository.CategoriaRepository;
import com.codeonblue.shop2.repository.ProdutoRepository;
import com.codeonblue.shop2.validator.ProdutoValidator;

@Controller
public class ProdutoController {

	private ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;
	private ProdutoValidator produtoValidator;
	
	@Autowired
	public ProdutoController(ProdutoRepository produtoRepository,
			CategoriaRepository categoriaRepository,
			ProdutoValidator produtoValidator) {
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
		this.produtoValidator = produtoValidator;
	}

	@InitBinder("produto")
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}
	
	
	@RequestMapping("/produtos")
	public String lista(Model model) {
		model.addAttribute("produtos", produtoRepository.findAll());
		return "produto/lista";
	}

	@RequestMapping("/novoProduto")
	public String form(Model model) {
		model.addAttribute("produto", new Produto());
		model.addAttribute("categorias", categoriaRepository.findAllOrderByNome());
		return "produto/formulario";
	}

	@RequestMapping("editaProduto")
	public String alteraLivro(@RequestParam("idCategoria") int idCategoria,
			@Valid Produto produto, BindingResult result, Model model) {

		if (result.hasFieldErrors()) {
			if (idCategoria > 0) {
				model.addAttribute("idCategoriaSelecionada", idCategoria);
			}
			model.addAttribute("categorias", categoriaRepository.findAllOrderByNome());
			return "produto/mostra";
		}
		if (idCategoria > 0) {
			Categoria categoriaSelecionada = categoriaRepository.findOne(idCategoria);
			produto.setCategoria(categoriaSelecionada);
		}
		produtoRepository.save(produto);
		return "redirect:produtos";
	}

	@RequestMapping("mostraProduto")
	public String mostraLivro(Model model, Integer id, Integer idCategoria,
			Long idAutor) {
		Produto produto = produtoRepository.findOne(id);
		model.addAttribute("produto", produto);
		if (produto.getCategoria() != null) {
			model.addAttribute("idCategoriaSelecionada", produto.getCategoria().getId());
		}
		model.addAttribute("categorias", categoriaRepository.findAllOrderByNome());
		return "produto/mostra";
	}

	@RequestMapping("/adicionaProduto")
	public String adiciona(@RequestParam("idCategoria") int idCategoria, @Valid Produto produto,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("categorias", categoriaRepository.findAllOrderByNome());
			return "produto/formulario";
		}
		Categoria categoriaSelecionada = categoriaRepository.findOne(idCategoria);
		produto.setCategoria(categoriaSelecionada);
		produtoRepository.save(produto);
		return "redirect:produtos";
	}


	@RequestMapping("removeProduto")
	public String removeProduto(Produto produto) {
		produtoRepository.delete(produto);
		return "redirect:produtos";
	}

}
