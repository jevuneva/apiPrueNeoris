package com.cleanAqruitect.CleanArquitect.dominio.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;

import java.util.List;

public interface PersonRepository {

    Person getById(Long id);

    // Save operation
    Person save(Person person) ;

    // Read operation
    List<Person> getAll();

    // Update operation
    Person update(Person person, Long personId);

    // Delete operation
    void deleteById(Long personId);

}
