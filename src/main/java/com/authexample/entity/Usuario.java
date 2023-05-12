package com.authexample.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(length = 75, nullable = false)
	private String apellidos;

	@Column(length = 2, nullable = false)
	private int edad;

	@Column(length = 8, nullable = false)
	private String dni;

	@Column(length = 150, unique = true, nullable = false)
	private String correo;

	@Column(length = 255, nullable = false)
	private String contrasena;

	@Column(nullable = false)
	private boolean activo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_usuario_rol", joinColumns = @JoinColumn(name = "idusuario", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "idrol", referencedColumnName = "id"))
	private Set<Rol> roles = new HashSet<Rol>();

	public Usuario() {

	}

	public Usuario(String nombre, String apellidos, int edad, String dni, String correo, String contrasena,
			boolean activo, Set<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.dni = dni;
		this.correo = correo;
		this.contrasena = contrasena;
		this.activo = activo;
		this.roles = roles;
	}

}
