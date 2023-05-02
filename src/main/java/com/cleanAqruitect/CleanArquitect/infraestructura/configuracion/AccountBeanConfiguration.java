package com.cleanAqruitect.CleanArquitect.infraestructura.configuracion;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl.AccountServiceImpl;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.AccountDtoMapperAccount;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.AccountRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.AccountDomainService;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl.AccountDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountBeanConfiguration {

    @Bean
    public AccountServiceImpl accountService(AccountDomainService accountDomainService, AccountDtoMapperAccount accountDtoMapperPerson){
        return new AccountServiceImpl(accountDomainService, accountDtoMapperPerson);
    }

    @Bean
    public AccountDomainServiceImpl accountDomainServiceImpl(AccountRepository accountRepository){
        return new AccountDomainServiceImpl(accountRepository);
    }
}
