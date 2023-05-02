package com.cleanAqruitect.CleanArquitect.aplicacion.mapper;


import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDtoMapperAccount {

    AccountDto toAccountDto(Account account);


    List<AccountDto> toListAccountDto(List<Account> listAccount);

    Account toAccount(AccountDto accountDto);


}
