package com.cleanAqruitect.CleanArquitect.infraestructura.configuracion;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.AccountService;
import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl.MovementServiceImpl;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.MovementDtoMapperMovement;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.MovementRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.MovementDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl.MovementDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementBeanConfiguration {

    @Bean
    public MovementServiceImpl movementService(MovementDomainService movementDomainService, MovementDtoMapperMovement movementDtoMapperPerson){
        return new MovementServiceImpl(movementDomainService, movementDtoMapperPerson);
    }

    @Bean
    public MovementDomainServiceImpl movementDomainServiceImpl(MovementRepository movementRepository, AccountService accountService){
        return new MovementDomainServiceImpl(movementRepository, accountService);
    }
}
