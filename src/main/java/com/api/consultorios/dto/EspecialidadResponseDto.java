package com.api.consultorios.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadResponseDto {
    private Long id;
    private String descripcion;
    private String observaciones;
}
