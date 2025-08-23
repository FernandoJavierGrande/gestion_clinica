package com.api.consultorios.dto;

import java.util.List;

import com.api.consultorios.entity.Duracion_turno;
import com.api.consultorios.entity.Especialidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalResponseDto {
	
	private String matricula;
	
	private String nacimiento;
	
	private String nombre;

	private String cuil;
		
	private String telefono;
		
	private String mail;
	
	private String observaciones;
	
	private List<Especialidad> especialidades;  
	
	private Duracion_turno duracion;
}
