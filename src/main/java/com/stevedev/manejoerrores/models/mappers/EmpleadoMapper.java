package com.stevedev.manejoerrores.models.mappers;

import com.stevedev.manejoerrores.models.dto.request.CreateEmpleado;
import com.stevedev.manejoerrores.models.dto.request.UpdateEmpleado;
import com.stevedev.manejoerrores.models.dto.response.EmpleadoResponse;
import com.stevedev.manejoerrores.models.entities.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    EmpleadoResponse toResponse(Empleado empleado);

    @Mapping(target = "id", ignore = true)
    Empleado toEntityC(CreateEmpleado createEmpleado);

    @Mapping(target = "id", ignore = true)
    Empleado toEntityU(UpdateEmpleado updateEmpleado);
}
