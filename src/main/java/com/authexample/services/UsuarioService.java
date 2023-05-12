package com.authexample.services;

import com.authexample.payload.request.auth.SignUpRequest;

public interface UsuarioService {
	Boolean existeCorreo(String correo);

	void registrar(SignUpRequest signUpRequest);
}
