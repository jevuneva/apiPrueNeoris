package com.cleanAqruitect.CleanArquitect.dominio.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;

import java.util.List;

public interface MovementRepository {

    Movement getById(Long id);

    // Save operation
    Movement save(Movement movement) ;

    // Read operation
    List<Movement> getAll();

    // Update operation
    Movement update(Movement movement, Long movementId);

    // Delete operation
    void deleteById(Long movementId);

    float vrMovement(long idAccount, String typeMovement);
}
