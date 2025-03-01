package com.stevedev.manejoerrores.models.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateEmpleado {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El DUI es requerido")
    private String dui;

    @NotBlank(message = "El email es requerido")
    @Email(message = "El email no es válido")
    private String email;

    @NotNull(message = "El salario es requerido")
    @Positive(message = "El salario debe ser mayor a 0")
    private Double salario;

    @NotBlank(message = "El cargo es requerido")
    private String cargo;
}
