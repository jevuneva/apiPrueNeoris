package com.cleanAqruitect.CleanArquitect.infraestructura.dao;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {

}
