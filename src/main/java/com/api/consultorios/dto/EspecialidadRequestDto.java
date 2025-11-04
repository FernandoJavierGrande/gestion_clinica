package com.api.consultorios.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadRequestDto {
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    private String observaciones;
}