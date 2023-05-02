package com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.AccountRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.AccountDomainService;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccountDomainServiceImpl  implements AccountDomainService {

    private final AccountRepository accountRepository;

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> fetchAccountList() {
        return accountRepository.getAll();
    }

    @Override
    public Account updateAccount(Account account, Long accountId) {
        Account accountDB = accountRepository.getById(accountId);
        if (!Objects.nonNull(accountDB)) {
            throw new EntityNotFoundException("No se Encontro Id de la Cuenta");
        }
        account.setId(accountId);
        account.setMovementList(new ArrayList<>());
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountRepository.deleteById(accountId);
    }

    @Override
    public Account findAccountByNroCuenta(String nroCuenta) {
       try {
           return accountRepository.findAccountByNroCuenta(nroCuenta);
       } catch (Exception e){
           throw new EntityNotFoundException("Cuenta no Encontrada");
       }
    }

    @Override
    public List<Account> fetchReportaccount(String clientId, Date fecini, Date fecfin){
        List<Account> accountList = accountRepository.fetchReportaccount(clientId, fecini, fecfin);


        for(Account acc: accountList){

            List<Movement> listaFil = acc.getMovementList().stream()
                    .filter(obj -> !obj.getDateMov().before(fecini) && !obj.getDateMov().after(fecfin))
                    .collect(Collectors.toList());
            acc.setMovementList(listaFil);
        }

        return accountList;
    }
}
