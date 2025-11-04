// PacienteResponseDto.java
package com.api.consultorios.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponseDto {
    
    private Long id;
    private String nombre;
    private String apellido;
    @JsonProperty("CUIL")
    private String CUIL;
    private String numAfiliado;
    private String mail;
    private String domicilio;
    private String nacimiento;
    private String sexo;
    private String observaciones;
}