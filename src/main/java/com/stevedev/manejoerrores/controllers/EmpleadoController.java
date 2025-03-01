package com.stevedev.manejoerrores.controllers;

import com.stevedev.manejoerrores.models.dto.request.CreateEmpleado;
import com.stevedev.manejoerrores.models.dto.request.UpdateEmpleado;
import com.stevedev.manejoerrores.models.dto.response.EmpleadoResponse;
import com.stevedev.manejoerrores.services.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<Page<EmpleadoResponse>> findAll(Pageable pageable) {
        Page<EmpleadoResponse> empleados = empleadoService.findAll(pageable);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> findById(@PathVariable Long id) {
        EmpleadoResponse empleado = empleadoService.findById(id);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponse> save(@Valid @RequestBody CreateEmpleado createEmpleado) {
        EmpleadoResponse empleado = empleadoService.save(createEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateEmpleado updateEmpleado) {
        EmpleadoResponse empleado = empleadoService.update(id, updateEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre")
    public ResponseEntity<Page<EmpleadoResponse>> findAll(@RequestParam String nombre, Pageable pageable) {
        Page<EmpleadoResponse> empleados = empleadoService.findByNombre(nombre, pageable);
        return ResponseEntity.ok(empleados);
    }
}
