package com.api.consultorios.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.consultorios.dto.EspecialidadRequestDto;
import com.api.consultorios.dto.EspecialidadResponseDto;
import com.api.consultorios.entity.Especialidad;
import com.api.consultorios.repository.EspecialidadRepository;

@Service
public class EspecialidadService implements IServiceEspecialidad {
    
    @Autowired
    private EspecialidadRepository eRepo;
    
    @Autowired
    private ModelMapper mapper;
    
    public List<EspecialidadResponseDto> getEspecialidades() {
        return eRepo.findAll().stream()
                .map(e -> mapper.map(e, EspecialidadResponseDto.class))
                .collect(Collectors.toList());
    }
    
    @Transactional
    @Override
    public EspecialidadResponseDto createEspecialidad(EspecialidadRequestDto request) {
        Especialidad especialidad = mapper.map(request, Especialidad.class);
        return mapper.map(eRepo.save(especialidad), EspecialidadResponseDto.class);
    }
    
    @Transactional
    @Override
    public EspecialidadResponseDto updateEspecialidad(Long id, EspecialidadRequestDto request) {
        Especialidad especialidad = eRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Especialidad no encontrada"));
        
        mapper.map(request, especialidad);
        return mapper.map(eRepo.save(especialidad), EspecialidadResponseDto.class);
    }
    
    @Transactional
    @Override
    public void deleteEspecialidad(Long id) {
        if (!eRepo.existsById(id)) {
            throw new IllegalArgumentException("Especialidad no encontrada");
        }
        try {
            eRepo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la especialidad porque está asignada a uno o más profesionales");
        }
    }
}