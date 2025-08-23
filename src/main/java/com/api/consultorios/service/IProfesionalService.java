package com.api.consultorios.service;

import java.util.List;

import com.api.consultorios.dto.ProfesionalRequestDto;
import com.api.consultorios.dto.ProfesionalResponseDto;

public interface IProfesionalService {
	ProfesionalRequestDto createProfesional(ProfesionalRequestDto profesionalDto); // ver que necesito
	
	ProfesionalRequestDto getProfesional(Long id);
	
	void updateProfesional(Long id, ProfesionalRequestDto profesionalDto );
	
	Long deleteCliente(Long id);
	
	List<ProfesionalResponseDto> getProfesionales();
}
