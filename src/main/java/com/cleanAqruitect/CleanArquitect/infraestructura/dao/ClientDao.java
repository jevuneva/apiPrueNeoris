package com.cleanAqruitect.CleanArquitect.infraestructura.dao;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ClientDao extends JpaRepository<Client, Long>, QueryByExampleExecutor<Client> {

    @Query(value = "SELECT * FROM person WHERE persontype = 'client' and identificacion = :ident "
            , nativeQuery = true)
    public Client getClientByIdent(@Param("ident") String identificacion);
}
