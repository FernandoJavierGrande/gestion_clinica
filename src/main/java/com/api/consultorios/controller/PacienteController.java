package com.api.consultorios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.consultorios.dto.PacienteRequestDto;
import com.api.consultorios.dto.PacienteResponseDto;
import com.api.consultorios.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

	
	@Autowired
    private PacienteService pService;
    
    @GetMapping
    public ResponseEntity<List<PacienteResponseDto>> getPacientes() {
        return ResponseEntity.ok(pService.getPacientes());
    }
    
    @PostMapping
    public ResponseEntity<PacienteResponseDto> createPaciente(@Valid @RequestBody PacienteRequestDto request) {
        return ResponseEntity.ok(pService.createPaciente(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDto> updatePaciente(
            @PathVariable Long id,
            @Valid @RequestBody PacienteRequestDto request) {
        return ResponseEntity.ok(pService.updatePaciente(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }
	
	
}
