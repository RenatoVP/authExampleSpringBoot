package com.authexample.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String nombre;
	private String apellidos;
	private String correo;
	private List<String> roles;

	public AuthenticationResponse(String token, Long id, String nombre, String apellidos, String correo, List<String> roles) {
		this.token = token;
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.roles = roles;
	}

}
