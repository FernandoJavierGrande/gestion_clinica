package com.api.consultorios.service;

import java.util.List;

import com.api.consultorios.dto.PacienteRequestDto;
import com.api.consultorios.dto.PacienteResponseDto;

public interface IPacienteService {
	
	List<PacienteResponseDto> getPacientes();
	
//	PacienteResponseDto getPacienteById(Long Id);
	
	PacienteResponseDto createPaciente(PacienteRequestDto paciente);
	
	PacienteResponseDto updatePaciente(Long id, PacienteRequestDto paciente);
	
	void deletePaciente(Long id);
}
