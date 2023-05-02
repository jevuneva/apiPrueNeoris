package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio;



import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto findClientById(Long id);

    // Save operation
    ClientDto saveClient(ClientDto client) ;

    // Read operation
    List<ClientDto> fetchClientList();

    // Update operation
    ClientDto updateClient(ClientDto client, Long clientId);

    // Delete operation
    void deleteClientById(Long clientId);

    ClientDto findClientByIdentif(String id);
}
