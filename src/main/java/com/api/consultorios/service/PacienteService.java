package com.api.consultorios.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consultorios.dto.PacienteRequestDto;
import com.api.consultorios.dto.PacienteResponseDto;
import com.api.consultorios.entity.Paciente;
import com.api.consultorios.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService implements IPacienteService {
	
	@Autowired
	PacienteRepository pRepo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<PacienteResponseDto> getPacientes() {
        return pRepo.findAll().stream()
                .map(p -> mapper.map(p, PacienteResponseDto.class))
                .collect(Collectors.toList());
    }
    
	
    @Transactional
    @Override
    public PacienteResponseDto createPaciente(PacienteRequestDto request) {
        Paciente paciente = mapper.map(request, Paciente.class);
        return mapper.map(pRepo.save(paciente), PacienteResponseDto.class);
    }
    
	
    @Transactional
    @Override
    public PacienteResponseDto updatePaciente(Long id, PacienteRequestDto request) {
        Paciente paciente = pRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
        
        mapper.map(request, paciente);
        
        return mapper.map(pRepo.save(paciente), PacienteResponseDto.class);
    }
    
	
    @Transactional
    @Override
    public void deletePaciente(Long id) {
        if (!pRepo.existsById(id)) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        pRepo.deleteById(id);
    }
	
}
