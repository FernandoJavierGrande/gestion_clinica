package com.api.consultorios.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "paciente")
@Data 
@NoArgsConstructor
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
//	@NotBlank(message = "El nombre es obligatorio")
	@Column(nullable = false)
	private String nombre;
	
//	@NotBlank(message = "El apellido es obligatorio")
	@Column(nullable = false)
	private String apellido;
	
//	@NotBlank(message = "El CUIL es obligatorio")
	@Column(nullable = false, unique = true)
	@JsonProperty("CUIL")
	private String CUIL;
	
//	@NotBlank(message = "El Número de afiliado es obligatorio")
	@Column(nullable = false, unique = true)
	private String numAfiliado;
	
//	@NotBlank(message = "El eMail es obligatorio")
	@Column(nullable = false)
	private String mail;
	
	private String domicilio;
	
	private Date nacimiento;
	
	private String sexo; 
	
	private String observaciones;
	
	@OneToMany
	private List<Turno> turno;
}
