package com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.Impl;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.AccountService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ReportJson;
import com.cleanAqruitect.CleanArquitect.aplicacion.mapper.AccountDtoMapperAccount;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.AccountDomainService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountDomainService accountDomainService;
    private final AccountDtoMapperAccount accountDtoMapperAccount;

    @Override
    public AccountDto findAccountById(Long id) {
        return accountDtoMapperAccount.toAccountDto(accountDomainService.findAccountById(id));
    }

    @Override
    public AccountDto saveAccount(AccountDto account) {
        return  accountDtoMapperAccount.toAccountDto(accountDomainService.saveAccount(
                accountDtoMapperAccount.toAccount(account)
        ));
    }

    @Override
    public List<AccountDto> fetchAccountList() {
        return accountDtoMapperAccount.toListAccountDto(accountDomainService.fetchAccountList());
    }

    @Override
    public AccountDto updateAccount(AccountDto account, Long accountId) {
        return  accountDtoMapperAccount.toAccountDto(accountDomainService.updateAccount(
                accountDtoMapperAccount.toAccount(account), accountId
        ));
    }

    @Override
    public void deleteAccountById(Long accountId) {
        accountDomainService.deleteAccountById(accountId);
    }

    @Override
    public AccountDto findAccountByNroAccount(String nroAccount){
        return accountDtoMapperAccount.toAccountDto(accountDomainService.findAccountByNroCuenta(nroAccount));
    }

    @Override
    public List<AccountDto> fetchReportAccount(String clientId, Date fecini, Date fecfin){
        return accountDtoMapperAccount.toListAccountDto(
                accountDomainService.fetchReportaccount(
                        clientId, fecini, fecfin
                ));
    }
    @Override
    public List<ReportJson> fetchReportAccountJson(String clientId, Date fecini, Date fecfin){
        List<ReportJson> report = new ArrayList<>();

        List<AccountDto> accountDtos =  accountDtoMapperAccount.toListAccountDto(
                accountDomainService.fetchReportaccount(
                        clientId, fecini, fecfin
                ));

        for (AccountDto account: accountDtos){
            for (Movement mov: account.getMovementList()){
                ReportJson rep = new ReportJson();
                rep.setFecha(mov.getDateMov());
                rep.setCliente(account.getClient().getNombre());
                rep.setNroCuenta(account.getNroAccount());
                rep.setTipo(account.getTypeAccount());
                rep.setSaldoInicial(account.getInitBalance());
                rep.setEstado(account.getStatus());
                rep.setMovimiento(mov.getValue());
                rep.setSaldoDisponible(mov.getBalance());
                report.add(rep);
            }

        }
        return  report;

    }
}
