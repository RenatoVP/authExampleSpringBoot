package com.authexample.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authexample.entity.Rol;
import com.authexample.exception.ResourceNotFoundException;
import com.authexample.repository.RolRepository;
import com.authexample.services.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public Rol buscarPorNombre(String nombre) {
		Rol rol = rolRepository.findByNombre(nombre)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso Rol no encontrado"));

		return rol;
	}

}
