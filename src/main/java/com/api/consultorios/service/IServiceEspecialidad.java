package com.api.consultorios.service;

import java.util.List;

import com.api.consultorios.dto.EspecialidadRequestDto;
import com.api.consultorios.dto.EspecialidadResponseDto;

public interface IServiceEspecialidad {
	
	EspecialidadResponseDto createEspecialidad (EspecialidadRequestDto especialidad);
	
	EspecialidadResponseDto updateEspecialidad(Long id, EspecialidadRequestDto especialidad);
	
	void deleteEspecialidad(Long id );
	
	List<EspecialidadResponseDto> getEspecialidades();
	
}
