package com.api.consultorios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.consultorios.entity.Duracion_turno;
import com.api.consultorios.repository.DuracionTurnosRepository;

@Service
public class DuracionService implements IDuracionService{
	
	@Autowired
	private DuracionTurnosRepository duracionRepo;
	
	@Override
	public List<Duracion_turno> getDuracion() {
		// TODO Auto-generated method stub
		return duracionRepo.findAll();
	}
}
