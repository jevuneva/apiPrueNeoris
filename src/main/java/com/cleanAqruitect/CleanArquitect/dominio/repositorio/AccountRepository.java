package com.cleanAqruitect.CleanArquitect.dominio.repositorio;


import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;

import java.util.Date;
import java.util.List;

public interface AccountRepository {

    Account getById(Long id);

    // Save operation
    Account save(Account account) ;

    // Read operation
    List<Account> getAll();

    // Update operation
    Account update(Account account, Long accountId);

    // Delete operation
    void deleteById(Long accountId);

    Account findAccountByNroCuenta(String nroCuenta);

     List<Account> fetchReportaccount(String clientId, Date fecini, Date fecfin);
}
