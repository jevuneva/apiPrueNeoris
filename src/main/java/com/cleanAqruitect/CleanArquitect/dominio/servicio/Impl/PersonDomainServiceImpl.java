package com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl;


import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.PersonDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.PersonRepository;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class PersonDomainServiceImpl implements PersonDomainService {

    private final PersonRepository personRepository;


    @Override
    public Person findPersonById(Long id) {

        return personRepository.getById(id);
    }

    @Override
    public Person savePerson(Person person) {

        return personRepository.save(person);
    }

    @Override
    public List<Person> fetchPersonList() {

        return personRepository.getAll();
    }

    @Override
    public Person updatePerson(Person person, Long personId) {
        Person perDB = personRepository.getById(personId);
        if (!Objects.nonNull(perDB)) {
            throw new EntityNotFoundException("No se Encontro Id de la Persona");
        }
        return personRepository.save(person);
    }

    @Override
    public void deletePersonById(Long personId) {
        personRepository.deleteById(personId);

    }
}
