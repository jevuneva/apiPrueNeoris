package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.MovementDto;

import java.util.List;

public interface MovementService {
    MovementDto findMovementById(Long id);

    // Save operation
    MovementDto saveMovement(MovementDto movement) ;

    // Read operation
    List<MovementDto> fetchMovementList();

    // Update operation
    MovementDto updateMovement(MovementDto movement, Long movementId);

    // Delete operation
    void deleteMovementById(Long movementId);
}
