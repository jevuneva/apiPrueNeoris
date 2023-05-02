package com.cleanAqruitect.CleanArquitect.aplicacion.mapper;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.MovementDto;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementDtoMapperMovement {

    MovementDto toMovementDto(Movement movement);


    List<MovementDto> toListMovementDto(List<Movement> listMovement);

    Movement toMovement(MovementDto movementDto);
}
