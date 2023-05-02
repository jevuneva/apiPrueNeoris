package com.cleanAqruitect.CleanArquitect.dominio.servicio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;

import java.util.List;

public interface PersonDomainService {

    Person findPersonById(Long id);

    // Save operation
    Person savePerson(Person person) ;

    // Read operation
    List<Person> fetchPersonList();

    // Update operation
    Person updatePerson(Person person, Long personId);

    // Delete operation
    void deletePersonById(Long personId);

}
