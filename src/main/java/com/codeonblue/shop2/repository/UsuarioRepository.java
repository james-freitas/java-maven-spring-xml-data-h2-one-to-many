package com.codeonblue.shop2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeonblue.shop2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
