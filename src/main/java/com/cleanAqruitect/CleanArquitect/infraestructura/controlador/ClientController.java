package com.cleanAqruitect.CleanArquitect.infraestructura.controlador;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.ClientService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientDto> findClientById(@PathVariable Long idClient){
        ClientDto clientDto = clientService.findClientById(idClient);
        return   ResponseEntity.status(HttpStatus.OK).body(clientDto);
    }

    @GetMapping("/byIdent/{identifi}")
    public ResponseEntity<ClientDto> findClientByIdentif(@PathVariable String identifi){
        ClientDto clientDto = clientService.findClientByIdentif(identifi);
        return   ResponseEntity.status(HttpStatus.OK).body(clientDto);
    }

    @GetMapping("/")
    public List<ClientDto> findClient(){
        List<ClientDto> clientDto = clientService.fetchClientList();
        return clientDto;

    }
    @PostMapping("/")
    public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto){
        ClientDto clientDto1 = clientService.saveClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto1);

    }

    @PutMapping("/{idClient}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long idClient, @RequestBody ClientDto clientDto){
        ClientDto clientDto1 = clientService.updateClient(clientDto, idClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientDto1);

    }

    @DeleteMapping ("/{idClient}")
    public ResponseEntity<String> deleteClient(@PathVariable Long idClient){
        clientService.deleteClientById(idClient);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado Correctamente: " + idClient.toString() );


    }


}
