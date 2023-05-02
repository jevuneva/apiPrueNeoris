package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto findPersonById(Long id);

    // Save operation
    PersonDto savePerson(PersonDto person) ;

    // Read operation
    List<PersonDto> fetchPersonList();

    // Update operation
    PersonDto updatePerson(PersonDto person, Long personId);

    // Delete operation
    void deletePersonById(Long personId);

}
