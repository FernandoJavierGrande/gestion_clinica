package com.api.consultorios.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.consultorios.dto.EspecialidadRequestDto;
import com.api.consultorios.dto.EspecialidadResponseDto;
import com.api.consultorios.service.EspecialidadService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController {
    
    @Autowired
    private EspecialidadService eService;
    
    @GetMapping
    public ResponseEntity<List<EspecialidadResponseDto>> getEspecialidades() {
        return ResponseEntity.ok(eService.getEspecialidades());
    }
    
    @PostMapping
    public ResponseEntity<EspecialidadResponseDto> createEspecialidad(@Valid @RequestBody EspecialidadRequestDto request) {
        return ResponseEntity.ok(eService.createEspecialidad(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadResponseDto> updateEspecialidad(
            @PathVariable Long id,
            @Valid @RequestBody EspecialidadRequestDto request) {
        return ResponseEntity.ok(eService.updateEspecialidad(id, request));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspecialidad(@PathVariable Long id) {
        eService.deleteEspecialidad(id);
        return ResponseEntity.noContent().build();
    }
}