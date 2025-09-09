package com.api.consultorios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.consultorios.entity.Turno;
import com.api.consultorios.service.TurnoService;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
	
	@Autowired
	private TurnoService turnoService;
	
	
	@GetMapping
	public ResponseEntity<List<Turno>> getTurnos(){
	
		return ResponseEntity.ok(turnoService.obtenerTurnos());
	}
}
