package com.cleanAqruitect.CleanArquitect.aplicacion.mapper;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.PersonDto;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonDtoMapperPerson {


    PersonDto toPersonDto(Person person);

    List<PersonDto> toListPersonDto(List<Person> listpeople);


    Person toPerson(PersonDto personDto);

}
