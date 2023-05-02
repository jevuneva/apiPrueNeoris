package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ReportJson;

import java.util.Date;
import java.util.List;

public interface AccountService {

    AccountDto findAccountById(Long id);

    // Save operation
    AccountDto saveAccount(AccountDto account) ;

    // Read operation
    List<AccountDto> fetchAccountList();

    // Update operation
    AccountDto updateAccount(AccountDto account, Long accountId);

    // Delete operation
    void deleteAccountById(Long accountId);

    AccountDto findAccountByNroAccount(String nroAccount);

    List<AccountDto> fetchReportAccount(String clientId, Date fecini, Date fecfin);

    List<ReportJson> fetchReportAccountJson(String clientId, Date fecini, Date fecfin);
}
