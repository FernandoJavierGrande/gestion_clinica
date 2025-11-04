package com.api.consultorios.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "especialidad")
@Data
@NoArgsConstructor
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "La especialidad es obligatoria")
    @Column(nullable = false)
	private String descripcion;
	
	private String observaciones;
	
//	@ManyToMany(mappedBy = "especialidades")
//	@JsonIgnore
//    private List<Profesional> profesionales;
	
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Matricula> matriculas;
}
