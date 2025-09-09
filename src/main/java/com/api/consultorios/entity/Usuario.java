package com.api.consultorios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Table(name = "usuario")
@Data 
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	
	@NotBlank(message = "El Usuario es obligatorio")
	@Column(nullable = false)
	public String user;
	
	@NotBlank(message = "El Usuario es obligatorio")
	@Column(nullable = false)
	public String password;
	
	public String permisos; //["admin","user"]
	
	public String Observaciones;
	
}
