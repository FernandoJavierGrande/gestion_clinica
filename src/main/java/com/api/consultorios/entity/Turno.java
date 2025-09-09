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
	public Long Id; 
	
	
	public String estado; // revisar
	
	public Date creacion;
	
	public String observaciones;
	
	
	public Date hora;
	
	public Usuario usuario;
	@ManyToOne
	public Paciente paciente;
	
	@ManyToOne
	public Consultorio consultorio;
	@ManyToOne
	public Profesional profesional;
}
