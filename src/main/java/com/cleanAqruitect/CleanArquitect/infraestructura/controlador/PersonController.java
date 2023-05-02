package com.cleanAqruitect.CleanArquitect.infraestructura.controlador;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.PersonService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    PersonService personServiceInterface;

    @GetMapping("/{idPerson}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long idPerson){
        PersonDto personDto = personServiceInterface.findPersonById(idPerson);
        return   ResponseEntity.status(HttpStatus.OK).body(personDto);
    }

    @GetMapping("/")
    public List<PersonDto> findPerson(){
        List<PersonDto> personDto = personServiceInterface.fetchPersonList();
        return personDto;

    }
    @PostMapping("/")
    public ResponseEntity<PersonDto> savePerson(@RequestBody PersonDto personDto){
        PersonDto personDto1 = personServiceInterface.savePerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDto1);

    }

    @PutMapping("/{idPerson}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable Long idPerson, @RequestBody PersonDto personDto){
        PersonDto personDto1 = personServiceInterface.updatePerson(personDto, idPerson);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDto1);

    }

    @DeleteMapping ("/{idPerson}")
    public ResponseEntity<String> deletePerson(@PathVariable Long idPerson){
        personServiceInterface.deletePersonById(idPerson);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado Correctamente: " + idPerson.toString() );


    }

}
