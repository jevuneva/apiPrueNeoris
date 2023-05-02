package com.cleanAqruitect.CleanArquitect.infraestructura.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.MovementRepository;
import com.cleanAqruitect.CleanArquitect.infraestructura.dao.MovementDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MovementRepositoryImpl implements MovementRepository {

    private final MovementDao movementDao;

    @Override
    public Movement getById(Long id) {
        return movementDao.getById(id);
    }

    @Override
    public Movement save(Movement movement) {
        return movementDao.save(movement);
    }

    @Override
    public List<Movement> getAll() {
        return movementDao.findAll();
    }

    @Override
    public Movement update(Movement movement, Long movementId) {
        return null;
    }

    @Override
    public void deleteById(Long movementId) {
        movementDao.deleteById(movementId);
    }

    @Override
    public float vrMovement(long idAccount, String typeMovement){
       return movementDao.getValMovementByAccount(idAccount, typeMovement);
    }

}
