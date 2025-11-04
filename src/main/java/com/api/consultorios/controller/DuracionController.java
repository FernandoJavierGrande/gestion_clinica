package com.api.consultorios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.consultorios.entity.Duracion_turno;
import com.api.consultorios.service.DuracionService;

@RestController
@RequestMapping("/api/duracion")
public class DuracionController {
	
	
	
	@Autowired
	private DuracionService duracionService;
	
	@GetMapping
	public ResponseEntity<List<Duracion_turno>> getDuracion(){
		
		return ResponseEntity.ok(duracionService.getDuracion());
	}
}
