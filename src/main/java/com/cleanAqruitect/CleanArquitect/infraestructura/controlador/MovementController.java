package com.cleanAqruitect.CleanArquitect.infraestructura.controlador;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.MovementService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.MovementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimientos")
public class MovementController {

    @Autowired
    MovementService movementService;

    @GetMapping("/{idMovement}")
    public ResponseEntity<MovementDto> findMovementById(@PathVariable Long idMovement){
        MovementDto movementDto = movementService.findMovementById(idMovement);
        return   ResponseEntity.status(HttpStatus.OK).body(movementDto);
    }

    @GetMapping("/")
    public List<MovementDto> findMovement(){
        List<MovementDto> movementDto = movementService.fetchMovementList();
        return movementDto;

    }
    @PostMapping("/")
    public ResponseEntity<MovementDto> saveMovement(@RequestBody MovementDto movementDto){
        MovementDto movementDto1 = movementService.saveMovement(movementDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movementDto1);

    }

    @PutMapping("/{idMovement}")
    public ResponseEntity<MovementDto> updateMovement(@PathVariable Long idMovement, @RequestBody MovementDto movementDto){
        MovementDto movementDto1 = movementService.updateMovement(movementDto, idMovement);
        return ResponseEntity.status(HttpStatus.CREATED).body(movementDto1);

    }

    @DeleteMapping ("/{idMovement}")
    public ResponseEntity<String> deleteMovement(@PathVariable Long idMovement){
        movementService.deleteMovementById(idMovement);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado Correctamente: " + idMovement.toString() );


    }


}
