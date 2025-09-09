package com.api.consultorios.entity;

import java.util.Date;

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
@Table(name = "paciente")
@Data 
@NoArgsConstructor
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	
	@NotBlank(message = "El nombre es obligatorio")
	@Column(nullable = false)
	public String nombre;
	
	@NotBlank(message = "El apellido es obligatorio")
	@Column(nullable = false)
	public String apellido;
	
	@NotBlank(message = "El CUIL es obligatorio")
	@Column(nullable = false)
	public String CUIL;
	
	@NotBlank(message = "El Número de afiliado es obligatorio")
	@Column(nullable = false)
	public String numAfiliado;
	
	@NotBlank(message = "El eMail es obligatorio")
	@Column(nullable = false)
	public String mail;
	
	public String domicilio;
	
	public Date nacimiento;
	
	public String sexo; 
	
	public String observaciones;
}
