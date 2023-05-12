package com.authexample.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authexample.payload.request.auth.SignUpRequest;
import com.authexample.payload.request.auth.LoginRequest;
import com.authexample.payload.response.AuthenticationResponse;
import com.authexample.security.jwt.JwtUtils;
import com.authexample.security.services.CustomUserDetails;
import com.authexample.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/ingresar")
	public ResponseEntity<AuthenticationResponse> ingresar(@RequestBody @Valid LoginRequest usuarioLoginDTO) {
		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(usuarioLoginDTO.getCorreo(), usuarioLoginDTO.getContrasena()));

		SecurityContextHolder.getContext().setAuthentication(auth);

		CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();

		// Obtenemos el token del jwt
		String token = jwtUtils.generateJwtToken(userDetails);

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity
				.ok(new AuthenticationResponse(token, userDetails.getUsuario().getId(), userDetails.getUsuario().getNombre(),
						userDetails.getUsuario().getApellidos(), userDetails.getUsuario().getCorreo(), roles));
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody @Valid SignUpRequest signUpRequest) {

		// Si el correo ingresado a registrar ya existe
		if (usuarioService.existeCorreo(signUpRequest.getCorreo())) {
			return new ResponseEntity<>("El correo ingresado ya esta en uso.", HttpStatus.BAD_REQUEST);
		}

		// Sino registramos al usuario
		// 1. Registramos el usuario y con los roles
		usuarioService.registrar(signUpRequest);

		return ResponseEntity.ok("Usuario registrado exitosamente");
	}

}
