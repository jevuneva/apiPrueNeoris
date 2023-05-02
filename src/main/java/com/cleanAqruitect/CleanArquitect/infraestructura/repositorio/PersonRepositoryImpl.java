package com.cleanAqruitect.CleanArquitect.infraestructura.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Person;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.PersonRepository;
import com.cleanAqruitect.CleanArquitect.infraestructura.dao.PersonDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonDao personDao;

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    public List<Person> getAll() {

        return personDao.findAll();
    }

    @Override
    public Person update(Person person, Long personId) {
       return null;
    }

    @Override
    public void deleteById(Long personId) {
            personDao.deleteById(personId);
    }


}
