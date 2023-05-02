package com.cleanAqruitect.CleanArquitect.dominio.servicio;



import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;

import java.util.Date;
import java.util.List;

public interface AccountDomainService {

    Account findAccountById(Long id);

    // Save operation
    Account saveAccount(Account account) ;

    // Read operation
    List<Account> fetchAccountList();

    // Update operation
    Account updateAccount(Account account, Long accountId);

    // Delete operation
    void deleteAccountById(Long accountId);

    Account findAccountByNroCuenta(String nroCuenta);

    List<Account> fetchReportaccount(String clientId, Date fecini, Date fecfin);
}
