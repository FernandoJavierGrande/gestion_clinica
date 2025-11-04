// PacienteRequestDto.java
package com.api.consultorios.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDto {
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    
    @NotBlank(message = "El CUIL es obligatorio")
    @JsonProperty("CUIL")
    private String CUIL;
    
    @NotBlank(message = "El número de afiliado es obligatorio")
    private String numAfiliado;
    
    @NotBlank(message = "El email es obligatorio")
    private String mail;
    
    private String domicilio;
    private String nacimiento; // Cambié a String para facilitar el manejo desde frontend
    private String sexo;
    private String observaciones;
}