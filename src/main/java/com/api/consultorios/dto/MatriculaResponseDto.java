package com.api.consultorios.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaResponseDto {
	
	private Long id;
	
    private String numeroMatricula;
    
    private EspecialidadResponseDto especialidad;
    
}
