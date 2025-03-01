package com.stevedev.manejoerrores.models.dto.response;

import lombok.Data;

@Data
public class EmpleadoResponse {
    private Long id;
    private String nombre;
    private String dui;
    private String email;
    private Double salario;
    private String cargo;
}
