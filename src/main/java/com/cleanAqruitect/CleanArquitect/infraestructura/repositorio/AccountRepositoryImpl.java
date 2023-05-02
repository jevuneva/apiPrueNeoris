package com.cleanAqruitect.CleanArquitect.infraestructura.repositorio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.AccountRepository;
import com.cleanAqruitect.CleanArquitect.infraestructura.dao.AccountDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountDao accountDao;

    @Override
    public Account getById(Long id) {
        return accountDao.getById(id);
    }

    @Override
    public Account save(Account account) {
        return accountDao.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountDao.findAll();
    }

    @Override
    public Account update(Account account, Long accountId) {
        return null;
    }

    @Override
    public void deleteById(Long accountId) {
        accountDao.deleteById(accountId);
    }

    @Override
    public Account findAccountByNroCuenta(String nroCuenta) {
        return accountDao.getAccountbyNroAccount(nroCuenta).get(0);
    }

    @Override
    public List<Account> fetchReportaccount(String clientId, Date fecini, Date fecfin){
        return accountDao.fetchReportaccount(clientId, fecini, fecfin);
    }

}
