package com.api.consultorios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consultorios.dto.ProfesionalRequestDto;
import com.api.consultorios.dto.ProfesionalResponseDto;
import com.api.consultorios.entity.Especialidad;
import com.api.consultorios.entity.Profesional;
import com.api.consultorios.repository.DuracionTurnosRepository;
import com.api.consultorios.repository.EspecialidadRepository;
import com.api.consultorios.repository.ProfesionalRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfesionalService implements IProfesionalService{
	
	// inyeccion de dependencia
	@Autowired 
	private ProfesionalRepository pRepo;
	
	@Autowired 
	private DuracionTurnosRepository dRepo;
	
	@Autowired
	private EspecialidadRepository eRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	@Transactional
	public ProfesionalRequestDto createProfesional(ProfesionalRequestDto profesionalReqDto) {
		 
		Profesional profesional = mapper.map(profesionalReqDto, Profesional.class);
		
		profesional.setDuracion_turno(dRepo.findById(profesionalReqDto.getDuracion_turno_id()).
				orElseThrow(() -> new IllegalArgumentException("Duración no encontrada")));
		
		if (profesionalReqDto.getEspecialidades_id() != null && !profesionalReqDto.getEspecialidades_id().isEmpty()) {
			
	        List<Especialidad> especialidades = profesionalReqDto.getEspecialidades_id().stream()
	        		.map(id -> eRepo.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada: " + id))).toList();
	        
			profesional.setEspecialidades(especialidades);	        
			
		}
		
		return mapper.map(pRepo.save(profesional), ProfesionalRequestDto.class);
	}
	@Override
	public ProfesionalRequestDto getProfesional(Long id) {
		
		return mapper.map(pRepo.findById(id), ProfesionalRequestDto.class);
	}
	@Override
	public Long deleteCliente(Long id) {
		pRepo.deleteById(id);
		return id;
	}
	@Override
	public void updateProfesional(Long id, ProfesionalRequestDto profesionalDto) {		
		mapper.map(pRepo.save(mapper.map(profesionalDto, Profesional.class)), ProfesionalRequestDto.class);
	}
	
	@Override
	public List<ProfesionalResponseDto> getProfesionales() {	
		
		List<Profesional> lsProfesional = pRepo.getProfesionales();	
		List<ProfesionalResponseDto> lsProfesionalDto = new ArrayList<>();
		
		for (Profesional profesional : lsProfesional) {
			
			ProfesionalResponseDto pDto = mapper.map(profesional, ProfesionalResponseDto.class);
			lsProfesionalDto.add(pDto);			
		}
		
		return lsProfesionalDto;
	}
}
