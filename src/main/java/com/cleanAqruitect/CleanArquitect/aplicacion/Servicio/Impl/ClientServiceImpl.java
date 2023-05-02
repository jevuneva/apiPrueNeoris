package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl;


import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.ClientService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ClientDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.ClientDtoMapperClient;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.ClientDomainService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClientServiceImpl  implements ClientService {

    private final ClientDomainService clientDomainService;
    private final ClientDtoMapperClient clientDtoMapperClient;

    @Override
    public ClientDto findClientById(Long id) {
        return clientDtoMapperClient.toClientDto(clientDomainService.findClientById(id));
    }

    @Override
    public ClientDto saveClient(ClientDto client) {
        return  clientDtoMapperClient.toClientDto(clientDomainService.saveClient(
                clientDtoMapperClient.toClient(client)
        ));
    }

    @Override
    public List<ClientDto> fetchClientList() {
        return clientDtoMapperClient.toListClientDto(clientDomainService.fetchClientList());
    }

    @Override
    public ClientDto updateClient(ClientDto client, Long clientId) {
        return  clientDtoMapperClient.toClientDto(clientDomainService.updateClient(
                clientDtoMapperClient.toClient(client), clientId
        ));
    }

    @Override
    public void deleteClientById(Long clientId) {
        clientDomainService.deleteClientById(clientId);
    }

    @Override
    public ClientDto findClientByIdentif(String id){
        return clientDtoMapperClient.toClientDto(clientDomainService.findClientByIdentif(id));
    }
}
