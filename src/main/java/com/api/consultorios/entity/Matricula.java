package com.api.consultorios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "matricula")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {
	
	private Long profesional_id;
	
	private Long Especialidad_id;
	
	private String descripcion;
}
