package com.api.consultorios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaRequestDto {
	
    private String numeroMatricula;
    private Long especialidadId;
}
