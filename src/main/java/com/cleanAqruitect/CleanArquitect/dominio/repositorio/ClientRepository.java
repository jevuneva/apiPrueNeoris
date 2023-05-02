package com.cleanAqruitect.CleanArquitect.dominio.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;

import java.util.List;

public interface ClientRepository {

    Client getById(Long id);

    // Save operation
    Client save(Client client) ;

    // Read operation
    List<Client> getAll();

    // Update operation
    Client update(Client client, Long clientId);

    // Delete operation
    void deleteById(Long clientId);

    Client findClientByIdentif(String id);
}
