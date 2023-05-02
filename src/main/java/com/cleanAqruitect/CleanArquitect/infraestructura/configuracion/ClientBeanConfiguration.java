package com.cleanAqruitect.CleanArquitect.infraestructura.configuracion;


import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl.ClientServiceImpl;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.ClientDtoMapperClient;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.ClientRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.ClientDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl.ClientDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientBeanConfiguration {
    @Bean
    public ClientServiceImpl clientService(ClientDomainService clientDomainService, ClientDtoMapperClient clientDtoMapperPerson){
        return new ClientServiceImpl(clientDomainService, clientDtoMapperPerson);
    }

    @Bean
    public ClientDomainServiceImpl clientDomainServiceImpl(ClientRepository clientRepository){
        return new ClientDomainServiceImpl(clientRepository);
    }
}
