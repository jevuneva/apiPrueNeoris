package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.MovementService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.MovementDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.MovementDtoMapperMovement;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.MovementDomainService;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class MovementServiceImpl implements MovementService {

    private final MovementDomainService movementDomainService;
    private final MovementDtoMapperMovement movementDtoMapperMovement;

    private static final String RETIRO = "Retiro";
    private static final String DEPOSITO = "Deposito";

    @Override
    public MovementDto findMovementById(Long id) {
        return movementDtoMapperMovement.toMovementDto(movementDomainService.findMovementById(id));
    }

    @Override
    public MovementDto saveMovement(MovementDto movement) {


            float vrRet = movementDomainService.vrMovement(
                    movement.getAccount().getId(),RETIRO);

            float vrDep = movementDomainService.vrMovement(
                    movement.getAccount().getId(),DEPOSITO);

            if (movement.getTypeMove().equals(RETIRO)){
                vrRet = vrRet + movement.getValue();
            }
            if (movement.getTypeMove().equals(DEPOSITO)){
                vrDep = vrDep + movement.getValue();
            }

            float vrbalance = movement.getAccount().getInitBalance() + vrDep - vrRet;
            if (vrbalance < 0){
                throw new IllegalArgumentException("Cuenta no tiene fondos Suficientes");
            } else{
               movement.setBalance(vrbalance);
            }

        return  movementDtoMapperMovement.toMovementDto(movementDomainService.saveMovement(
                movementDtoMapperMovement.toMovement(movement)
        ));
    }

    @Override
    public List<MovementDto> fetchMovementList() {
        return movementDtoMapperMovement.toListMovementDto(movementDomainService.fetchMovementList());
    }

    @Override
    public MovementDto updateMovement(MovementDto movement, Long movementId) {
        return  movementDtoMapperMovement.toMovementDto(movementDomainService.updateMovement(
                movementDtoMapperMovement.toMovement(movement), movementId
        ));
    }

    @Override
    public void deleteMovementById(Long movementId) {
        movementDomainService.deleteMovementById(movementId);
    }
}
