package com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.AccountService;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.AccountRepository;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.MovementRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.AccountDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.MovementDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class MovementDomainServiceImpl  implements MovementDomainService {

    private static final String RETIRO = "Retiro";
    private static final String DEPOSITO = "Deposito";

    private final MovementRepository movementRepository;

    private final AccountService accountService;

    @Override
    public Movement findMovementById(Long id) {
        return movementRepository.getById(id);
    }

    @Override
    public Movement saveMovement(Movement movement) {
        movement.setDateMov(new Date());
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> fetchMovementList() {
        return movementRepository.getAll();
    }

    @Override
    public Movement updateMovement(Movement movement, Long movementId) {
        Movement movementDB = movementRepository.getById(movementId);
        if (!Objects.nonNull(movementDB)) {
            throw new EntityNotFoundException("No se Encontro Id del Movimiento");
        }
        return movementRepository.save(movement);
    }

    @Override
    public void deleteMovementById(Long movementId) {
        movementRepository.deleteById(movementId);
    }

    @Override
    public float vrMovement(long idAccount, String typeMovement) {
        try {
            return movementRepository.vrMovement(idAccount, typeMovement);
        } catch (EntityNotFoundException e){
            return 0;
        }
    }


}