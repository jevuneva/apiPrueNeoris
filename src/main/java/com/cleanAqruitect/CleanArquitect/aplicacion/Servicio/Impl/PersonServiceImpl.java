package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.PersonService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.PersonDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.PersonDtoMapperPerson;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.PersonDomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    private final PersonDomainService personDomainService;
    private final PersonDtoMapperPerson personDtoMapperPerson;

    @Override
    public PersonDto findPersonById(Long id) {
        return personDtoMapperPerson.toPersonDto(personDomainService.findPersonById(id));
    }

    @Override
    public PersonDto savePerson(PersonDto personDto) {
        return personDtoMapperPerson.toPersonDto(
                personDomainService.savePerson(personDtoMapperPerson.toPerson(personDto)));
    }

    @Override
    public List<PersonDto> fetchPersonList() {
        return personDtoMapperPerson.toListPersonDto(personDomainService.fetchPersonList());
    }

    @Override
    public PersonDto updatePerson(PersonDto person, Long personId) {

        return personDtoMapperPerson.toPersonDto(personDomainService
                .updatePerson(personDtoMapperPerson.toPerson(person),personId));

    }

    @Override
    public void deletePersonById(Long personId) {
        personDomainService.deletePersonById(personId);
    }
}
