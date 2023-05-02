package com.cleanAqruitect.CleanArquitect.infraestructura.dao;



import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface MovementDao extends JpaRepository<Movement, Long>, QueryByExampleExecutor<Movement> {

    @Query(value = "SELECT sum(value) FROM movement WHERE account_id = :idAccount  " +
            " AND typemove = :typeMovement", nativeQuery = true)
    public float getValMovementByAccount(@Param("idAccount") Long idAccount, @Param("typeMovement")String typeMovement);
}
