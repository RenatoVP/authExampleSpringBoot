package com.authexample.payload.request.auth;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.authexample.utils.Validations;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "El correo del usuario no puede estar vacio.")
	@Email(regexp = Validations.EMAIL, message = "El correo del usuario no es valido.")
	private String correo;

	@NotBlank(message = "La contraseña del usuario no puede estar vacia.")
	@Length(min = 2, max = 255, message = "La contraseña debe tener entre 2 a 255 caracteres.")
	private String contrasena;
}
