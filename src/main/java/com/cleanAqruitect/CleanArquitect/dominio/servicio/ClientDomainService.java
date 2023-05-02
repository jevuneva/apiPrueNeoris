package com.cleanAqruitect.CleanArquitect.dominio.servicio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;

import java.util.List;

public interface ClientDomainService {

    Client findClientById(Long id);

    // Save operation
    Client saveClient(Client client) ;

    // Read operation
    List<Client> fetchClientList();

    // Update operation
    Client updateClient(Client client, Long clientId);

    // Delete operation
    void deleteClientById(Long clientId);

    Client findClientByIdentif(String id);
}
