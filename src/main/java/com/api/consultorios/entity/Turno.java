package com.api.consultorios.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turno")
@Data 
@NoArgsConstructor
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 
	
	
	private String estado; // revisar
	
	private Date creacion;
	
	private String observaciones;
	
	
	private Date hora;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Paciente paciente;	
	@ManyToOne
	private Consultorio consultorio;
	@ManyToOne
	private Profesional profesional;
}
