package com.api.consultorios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consultorios.dto.MatriculaRequestDto;
import com.api.consultorios.dto.MatriculaResponseDto;
import com.api.consultorios.dto.ProfesionalRequestDto;
import com.api.consultorios.dto.ProfesionalResponseDto;
import com.api.consultorios.entity.Duracion_turno;
import com.api.consultorios.entity.Especialidad;
import com.api.consultorios.entity.Matricula;
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
	public ProfesionalResponseDto createProfesional(ProfesionalRequestDto profesionalReqDto) {

	   
	    Profesional profesional = mapper.map(profesionalReqDto, Profesional.class);

	    
	    profesional.setDuracion_turno(
	        dRepo.findById(profesionalReqDto.getDuracion_turno_id())
	            .orElseThrow(() -> new IllegalArgumentException("Duración no encontrada"))
	    );

	    
	    if (profesionalReqDto.getMatriculas() != null && !profesionalReqDto.getMatriculas().isEmpty()) {

	        List<Matricula> matriculas = profesionalReqDto.getMatriculas().stream()
	        		.map(mDto -> {
	        	        Especialidad especialidad = eRepo.findById(mDto.getEspecialidadId())
	        	            .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada"));
	        	        
	                // Crear la entidad Matricula
	                Matricula matricula = new Matricula();
	                matricula.setNumeroMatricula(mDto.getNumeroMatricula());
	                matricula.setEspecialidad(especialidad);
	                matricula.setProfesional(profesional);

	                return matricula;
	            })
	            .toList();

	        
	        profesional.setMatriculas(matriculas);
	    }
	    
	    return mapper.map(pRepo.save(profesional), ProfesionalResponseDto.class);
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
	@Transactional
	public ProfesionalResponseDto updateProfesional(Long id, ProfesionalRequestDto profesionalReqDto) {
	    
	    // Buscar el profesional existente
	    Profesional profesional = pRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Profesional no encontrado con id: " + id));
	   
//	    profesional = mapper.map(profesionalReqDto, Profesional.class);  mapea a mano para evitar problemas
	    
	    profesional.setNombre(profesionalReqDto.getNombre());
	    profesional.setCuil(profesionalReqDto.getCuil());
	    profesional.setTelefono(profesionalReqDto.getTelefono());
	    profesional.setMail(profesionalReqDto.getMail());
	    profesional.setNacimiento(profesionalReqDto.getNacimiento());
	    profesional.setObservaciones(profesionalReqDto.getObservaciones());
	    
	    // Actualizar duración
	    profesional.setDuracion_turno(
	        dRepo.findById(profesionalReqDto.getDuracion_turno_id())
	            .orElseThrow(() -> new IllegalArgumentException("Duración no encontrada"))
	    );
	    
	    // Limpiar matrículas anteriores
	    if (profesional.getMatriculas() != null && !profesional.getMatriculas().isEmpty()) {
	        // Crear una copia de la lista para evitar ConcurrentModificationException
	        List<Matricula> matriculasAEliminar = new ArrayList<>(profesional.getMatriculas());
	        profesional.getMatriculas().clear();
	        
	        // Guardar para que se eliminen las matrículas
	        pRepo.save(profesional);
	        pRepo.flush(); // Forzar la eliminación antes de agregar nuevas
	    }
	    
	    // Agregar las nuevas matrículas
	    if (profesionalReqDto.getMatriculas() != null && !profesionalReqDto.getMatriculas().isEmpty()) {
	        List<Matricula> matriculas = profesionalReqDto.getMatriculas().stream()
	                .map(mDto -> {
	                    Especialidad especialidad = eRepo.findById(mDto.getEspecialidadId())
	                        .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada"));
	                    
	                    Matricula matricula = new Matricula();
	                    matricula.setNumeroMatricula(mDto.getNumeroMatricula());
	                    matricula.setEspecialidad(especialidad);
	                    matricula.setProfesional(profesional);
	                    
	                    return matricula;
	                })
	                .toList();
	        
	        profesional.getMatriculas().addAll(matriculas);
	    }
	    
	    // Guardar y devolver el ResponseDto
	    return mapper.map(pRepo.save(profesional), ProfesionalResponseDto.class);
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
	
	
	
	
	
//	private ProfesionalResponseDto convertToResponseDto(Profesional profesional) {
//	    ProfesionalResponseDto dto = new ProfesionalResponseDto();
//	    dto.setId(profesional.getId());
//	    dto.setNombre(profesional.getNombre());
//	    dto.setCuil(profesional.getCuil());
//	    dto.setTelefono(profesional.getTelefono());
//	    dto.setMail(profesional.getMail());
//	    dto.setNacimiento(profesional.getNacimiento());
//	    dto.setObservaciones(profesional.getObservaciones());
//	    dto.setDuracion(profesional.getDuracion_turno());
//	    
//	    // Convertir matrículas
//	    if (profesional.getMatriculas() != null) {
//	        List<MatriculaResponseDto> matriculasDto = profesional.getMatriculas().stream()
//	                .map(m -> {
//	                    MatriculaResponseDto mDto = new MatriculaResponseDto();
//	                    mDto.setId(m.getId());
//	                    mDto.setNumeroMatricula(m.getNumeroMatricula());
//	                    mDto.setEspecialidad(m.getEspecialidad());
//	                    return mDto;
//	                })
//	                .collect(Collectors.toList());
//	        dto.setMatriculas(matriculasDto);
//	    }
//	    
//	    return dto;
//	}
	
}
