package com.cleanAqruitect.CleanArquitect.dominio.servicio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;

import java.util.List;

public interface MovementDomainService {

    Movement findMovementById(Long id);

    // Save operation
    Movement saveMovement(Movement movement) ;

    // Read operation
    List<Movement> fetchMovementList();

    // Update operation
    Movement updateMovement(Movement movement, Long movementId);

    // Delete operation
    void deleteMovementById(Long movementId);

    float vrMovement(long idAccount, String typeMovement);
}
