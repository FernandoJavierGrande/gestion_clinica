package com.api.consultorios.service;

import java.util.List;

import com.api.consultorios.dto.ProfesionalRequestDto;
import com.api.consultorios.dto.ProfesionalResponseDto;

public interface IProfesionalService {
	ProfesionalResponseDto createProfesional(ProfesionalRequestDto profesionalDto); // ver que necesito
	
	ProfesionalRequestDto getProfesional(Long id);
	
	public ProfesionalResponseDto updateProfesional(Long id, ProfesionalRequestDto request);
	
	Long deleteCliente(Long id);
	
	List<ProfesionalResponseDto> getProfesionales();
}


