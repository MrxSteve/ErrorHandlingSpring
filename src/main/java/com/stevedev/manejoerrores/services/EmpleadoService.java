package com.stevedev.manejoerrores.services;

import com.stevedev.manejoerrores.errors.ResourceNotFoundException;
import com.stevedev.manejoerrores.models.dto.request.CreateEmpleado;
import com.stevedev.manejoerrores.models.dto.request.UpdateEmpleado;
import com.stevedev.manejoerrores.models.dto.response.EmpleadoResponse;
import com.stevedev.manejoerrores.models.entities.Empleado;
import com.stevedev.manejoerrores.models.mappers.EmpleadoMapper;
import com.stevedev.manejoerrores.models.repositories.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Transactional(readOnly = true)
    public Page<EmpleadoResponse> findAll(Pageable pageable) {
        Page<Empleado> empleados = empleadoRepository.findAll(pageable);

        return empleados.map(empleadoMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public EmpleadoResponse findById(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado con id " + id + " no encontrado"));

        return empleadoMapper.toResponse(empleado);
    }

    @Transactional
    public EmpleadoResponse save(CreateEmpleado createEmpleado) {
        Empleado empleado = empleadoMapper.toEntityC(createEmpleado);
        Empleado savedEmpleado = empleadoRepository.save(empleado);

        return empleadoMapper.toResponse(savedEmpleado);
    }

    @Transactional
    public EmpleadoResponse update(Long id, UpdateEmpleado updateEmpleado) {
        Empleado existingEmpleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado con id " + id + " no encontrado"));

        if (updateEmpleado.getNombre() != null) {
            existingEmpleado.setNombre(updateEmpleado.getNombre());
        }
        if (updateEmpleado.getDui() != null) {
            existingEmpleado.setDui(updateEmpleado.getDui());
        }
        if (updateEmpleado.getEmail() != null) {
            existingEmpleado.setEmail(updateEmpleado.getEmail());
        }
        if (updateEmpleado.getSalario() != null) {
            existingEmpleado.setSalario(updateEmpleado.getSalario());
        }
        if (updateEmpleado.getCargo() != null) {
            existingEmpleado.setCargo(updateEmpleado.getCargo());
        }

        Empleado savedEmpleado = empleadoRepository.save(existingEmpleado);

        return empleadoMapper.toResponse(savedEmpleado);
    }

    @Transactional
    public void delete(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado con id " + id + " no encontrado"));

        empleadoRepository.delete(empleado);
    }

    @Transactional(readOnly = true)
    public Page<EmpleadoResponse> findByNombre(String nombre, Pageable pageable) {
        Page<Empleado> empleados = empleadoRepository.findByNombreContainingIgnoreCase(nombre, pageable);

        return empleados.map(empleadoMapper::toResponse);
    }
}
