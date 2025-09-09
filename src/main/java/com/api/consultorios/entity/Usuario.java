package com.api.consultorios.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "usuario")
@Data 
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "El Usuario es obligatorio")
	@Column(nullable = false)
	private String user;
	
	@NotBlank(message = "El Usuario es obligatorio")
	@Column(nullable = false)
	private String password;
	
	private String permisos; //["admin","user"]
	
	private String Observaciones;
	
	
	@OneToMany
	private List<Turno> turnos;
	
}
