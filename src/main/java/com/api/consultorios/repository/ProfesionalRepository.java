package com.api.consultorios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.consultorios.entity.Profesional;

// cuando se extiende se heredan cruds basicos

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
	
	@Query(value =  "select p from Profesional p order by p.nombre")
	public List<Profesional> getProfesionales();
}
