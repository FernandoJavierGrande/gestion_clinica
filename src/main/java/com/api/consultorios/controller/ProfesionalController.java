package com.api.consultorios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.consultorios.dto.ProfesionalRequestDto;
import com.api.consultorios.dto.ProfesionalResponseDto;
import com.api.consultorios.service.ProfesionalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/profesional")
public class ProfesionalController {
	
	@Autowired
	private ProfesionalService pService;
	
	@PostMapping
	public ResponseEntity<ProfesionalResponseDto> createProfesional(@Valid @RequestBody ProfesionalRequestDto profesionalDto){
		return ResponseEntity.ok(pService.createProfesional(profesionalDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> Delete(@PathVariable Long id){
		
		return ResponseEntity.ok(pService.deleteCliente(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfesionalRequestDto> getProfesionalById(@PathVariable Long id){
		
			
		return ResponseEntity.ok(pService.getProfesional(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ProfesionalResponseDto>> getProfesionales(){
		
		return ResponseEntity.ok(pService.getProfesionales());
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfesionalResponseDto> updateProfesional(
	        @PathVariable Long id,
	        @Valid @RequestBody ProfesionalRequestDto request) {
	    
		System.out.println("---duracion turno*-- " + request.getDuracion_turno_id());
	    return ResponseEntity.ok(pService.updateProfesional(id, request));
	}
	
	
}
