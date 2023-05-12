package com.authexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authexample.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByNombre(String nombre);
}
