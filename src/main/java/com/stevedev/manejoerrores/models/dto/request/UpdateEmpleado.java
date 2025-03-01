package com.stevedev.manejoerrores.models.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UpdateEmpleado {
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    private String dui;

    @Email(message = "El email no es válido")
    private String email;

    @Positive(message = "El salario debe ser mayor a 0")
    private Double salario;

    private String cargo;
}
