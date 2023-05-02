package com.cleanAqruitect.CleanArquitect.aplicacion.mapper;


import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ClientDto;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientDtoMapperClient {

    ClientDto toClientDto(Client client);


    List<ClientDto> toListClientDto(List<Client> listClient);

    Client toClient(ClientDto clientDto);


}
