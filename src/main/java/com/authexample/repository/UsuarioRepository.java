package com.authexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authexample.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByCorreo(String correo);

	Boolean existsByCorreo(String correo);
}
