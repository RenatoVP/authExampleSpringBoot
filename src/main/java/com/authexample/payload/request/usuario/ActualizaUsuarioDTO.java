package com.authexample.payload.request.usuario;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActualizaUsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nombre;
	private String apellidos;
	private String dni;
}
