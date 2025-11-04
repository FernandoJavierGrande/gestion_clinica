package com.api.consultorios.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profesional")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "El CUIL es obligatorio")
    @Column(nullable = false, unique = true )
	private String cuil ;
	
	@NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
	private String nombre ;
	
	@NotBlank(message = "El telefono es obligatorio")
    @Column(nullable = false)
	private String telefono ;
	
	@NotBlank(message = "El eMAIL es obligorio")
    @Column(nullable = false)	
	private String mail ;
	
	@NotBlank(message = "La Fecha de nacimiento es obligatoria")
    @Column(nullable = false)
	private String nacimiento ;
	
	private String observaciones ;
	
	//Relaciona las tablas genera la consntraint, crea un obj de tipo duracion turno para acceder desde aca a las prop de la 'tabla'
    @ManyToOne
    @JoinColumn(name = "duracion_turno", nullable = false)
	private Duracion_turno duracion_turno;	
    
    //matriculas
//    @ManyToMany
//    @JsonIgnore
//    @JoinTable(name ="profesional_especialidad",
//    		   joinColumns = @JoinColumn(name = "profesional_id"),
//    		   inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
//    private List<Especialidad> especialidades;
	
    @OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Matricula> matriculas;
    
 
}
