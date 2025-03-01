package com.stevedev.manejoerrores.models.repositories;

import com.stevedev.manejoerrores.models.entities.Empleado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Page<Empleado> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
}
