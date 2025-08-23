package com.api.consultorios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<ProfesionalRequestDto> createProfesional(@Valid @RequestBody ProfesionalRequestDto profesionalDto){
	
		try	{
			return ResponseEntity.status(HttpStatus.CREATED).body(pService.createProfesional(profesionalDto));
		}
		catch (IllegalArgumentException e) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error"+ e.getMessage());
	    }
		// falta alguna validacion de uq sobre cuil y matricula
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} 
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfesionalRequestDto> getProfesionalById(@PathVariable Long id){
		
		return ResponseEntity.ok(pService.getProfesional(id));
	}
	
	@GetMapping
	public ResponseEntity<List<ProfesionalResponseDto>> getProfesionales(){
		
		return ResponseEntity.ok(pService.getProfesionales());
	}
	

}
