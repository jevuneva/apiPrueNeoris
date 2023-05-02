package com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.ClientRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.ClientDomainService;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class ClientDomainServiceImpl implements ClientDomainService {

    private final ClientRepository clientRepository;



    @Override
    public Client findClientById(Long id) {
        Client temp = clientRepository.getById(id);
        return temp;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> fetchClientList() {
        List<Client> list = clientRepository.getAll();
        return list;
    }

    @Override
    public Client updateClient(Client client, Long clientId) {
        Client clientDB = clientRepository.getById(clientId);
        if (!Objects.nonNull(clientDB)) {
            throw new EntityNotFoundException("No se Encontro Id del Cliente");
        }
        client.setId(clientId);
        client.setAccountList(new ArrayList<>());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client findClientByIdentif(String id){
        return clientRepository.findClientByIdentif(id);
    }
}
