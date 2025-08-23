package com.api.consultorios.dto;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionalRequestDto {

	@NotNull(message = "La matricula es obligatorio")
	private String matricula;
	
	@NotNull(message = "La fecha de nacimiento es obligatoria")
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private String nacimiento;
	
	@NotNull(message = "El nombre es obligatorio")
	private String nombre;

	@NotNull(message = "El CUIL es obligatorio")
	private String cuil;
		
	@NotNull(message = "El telefono es obligatorio")
	private String telefono;
		
	@NotNull(message = "El mail es obligatorio")
	private String mail;
	
	private String observaciones;
	
	@NotNull(message = "Debe agregar al menos una especialidad")
	private List<Long> especialidades_id;
	
	@NotNull(message = "La duracion del turno es obligatorio")
	@JsonProperty("duracion_id")
	private Long duracion_turno_id;
	
}
