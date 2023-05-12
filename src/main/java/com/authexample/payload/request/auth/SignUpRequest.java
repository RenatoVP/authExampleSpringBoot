package com.authexample.payload.request.auth;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.authexample.utils.Validations;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "El nombre no puede estar vacio.")
	@Length(min = 3, max = 50, message = "El nombre debe contener entre 3 a 50 caracteres.")
	@Pattern(regexp = Validations.TEXT_NOT_CONTAIN_SPACE, message = "El nombre solo permite el ingreso de caracteres y no se permite espacios ni caracteres especiales.")
	private String nombre;

	@NotBlank(message = "Los apellidos no pueden estar vacio.")
	@Length(min = 3, max = 50, message = "El nombre debe contener entre 3 a 50 caracteres.")
	@Pattern(regexp = Validations.TEXT, message = "Los apellidos solo permite el ingreso de caracteres.")
	private String apellidos;

	@Min(value = 18, message = "El valor minimo para edad es 18.")
	@Max(value = 100, message = "El valor maximo para edad es 100.")
	private int edad;

	@NotBlank(message = "El dni no puede estar vacio.")
	@Pattern(regexp = Validations.DNI, message = "El dni debe contener 8 digitos.")
	private String dni;

	@NotBlank(message = "El correo no puede estar vacio.")
	@Email(regexp = Validations.EMAIL, message = "El correo ingresado no es valido.")
	private String correo;

	@NotBlank(message = "La contraseña no puede estar vacia.")
	@Pattern(regexp = Validations.PASSWORD, message = "La contraseña debe ser minimo de 8 caracteres, contar con al menos 1 caracter especial y al menos un numero.")
	private String contrasena;

	@NotEmpty(message = "El usuario requiere al menos 1 rol.")
	private Set<String> roles;
}
