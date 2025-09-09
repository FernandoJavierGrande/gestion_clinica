package com.api.consultorios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consultorios.entity.Turno;
import com.api.consultorios.repository.TurnoRepository;

@Service
public class TurnoService implements ITurnoService {

	@Autowired
	private TurnoRepository turnoRepo;
	
	@Override
	public List<Turno> obtenerTurnos() {
		//enviar un mail
		// registro log 	
		return turnoRepo.findAll();
		
	}
	
}
