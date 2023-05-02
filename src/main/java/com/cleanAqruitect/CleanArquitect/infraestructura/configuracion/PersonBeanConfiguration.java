package com.cleanAqruitect.CleanArquitect.infraestructura.configuracion;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl.PersonServiceImpl;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.PersonDtoMapperPerson;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.PersonRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.PersonDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl.PersonDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonBeanConfiguration {

    @Bean
    public PersonServiceImpl personService(PersonDomainService personDomainService, PersonDtoMapperPerson personDtoMapperPerson){
        return new PersonServiceImpl(personDomainService, personDtoMapperPerson);
    }

    @Bean
    public PersonDomainServiceImpl personDomainServiceImpl(PersonRepository personRepository){
        return new PersonDomainServiceImpl(personRepository);
    }

}
