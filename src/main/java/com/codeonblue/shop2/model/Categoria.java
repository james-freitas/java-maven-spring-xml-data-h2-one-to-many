package com.codeonblue.shop2.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categoria", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome_categoria" }) })
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome_categoria", unique = true, nullable = false, length = 50)
	@NotEmpty(message = "{categoria.formulario.nome.vazia}")
	@Size(min = 4, message = "{categoria.formulario.nome.tamanho}")
	private String nome;

	// Se apagar a categoria, apaga os produtos também
	@OneToMany(mappedBy = "categoria", targetEntity = Produto.class, orphanRemoval = true)
	private Set<Produto> produtos = new HashSet<Produto>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
