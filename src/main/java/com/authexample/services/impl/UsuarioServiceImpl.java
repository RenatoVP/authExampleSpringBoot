package com.authexample.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authexample.entity.Rol;
import com.authexample.entity.Usuario;
import com.authexample.exception.ResourceNotFoundException;
import com.authexample.payload.request.auth.SignUpRequest;
import com.authexample.repository.RolRepository;
import com.authexample.repository.UsuarioRepository;
import com.authexample.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Boolean existeCorreo(String correo) {
		return usuarioRepository.existsByCorreo(correo);
	}

	@Override
	public void registrar(SignUpRequest signUpRequest) {
		// Los datos del signUpRequest lo asignamos en usuario para poder
		// registrar al usuario en la bd
		Usuario usuario = new Usuario();
		usuario.setNombre(signUpRequest.getNombre());
		usuario.setApellidos(signUpRequest.getApellidos());
		usuario.setEdad(signUpRequest.getEdad());
		usuario.setDni(signUpRequest.getDni());
		usuario.setCorreo(signUpRequest.getCorreo());
		usuario.setContrasena(passwordEncoder.encode(signUpRequest.getContrasena()));
		usuario.setActivo(true);

		// Obtenemos los roles ingresados en el signuprequest y realizamos una busqueda
		// de rol por nombre para obtener el rol completo y registrar los roles al usuario
		Set<String> strRoles = signUpRequest.getRoles();
		Set<Rol> roles = new HashSet<Rol>();

		for (String nombreRol : strRoles) {
			Rol rolEncontrado = rolRepository.findByNombre(nombreRol)
					.orElseThrow(() -> new ResourceNotFoundException("Recurso Rol no encontrado"));

			roles.add(rolEncontrado);
		}

		usuario.setRoles(roles);

		// Registramos al usuario
		usuarioRepository.save(usuario);
	}

}
