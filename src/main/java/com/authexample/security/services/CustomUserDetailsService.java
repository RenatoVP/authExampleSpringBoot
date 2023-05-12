package com.authexample.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authexample.entity.Usuario;
import com.authexample.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByCorreo(correo);

		if (usuario == null)
			throw new UsernameNotFoundException("No se ha encontrado al usuario con el email solicitado");

		return new CustomUserDetails(usuario);
	}

}
