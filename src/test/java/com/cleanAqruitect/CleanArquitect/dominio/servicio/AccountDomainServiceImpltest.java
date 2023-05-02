package com.cleanAqruitect.CleanArquitect.dominio.servicio;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import com.cleanAqruitect.CleanArquitect.dominio.repositorio.AccountRepository;
import com.cleanAqruitect.CleanArquitect.dominio.servicio.Impl.AccountDomainServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountDomainServiceImpltest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountDomainServiceImpl domainService;

    Account accountMock;

    List<Account> accountListMock;

    @BeforeEach
    void setUp() {
        accountMock = new Account();
        accountMock.setId(1L);
        accountMock.setNroAccount("123");
        accountMock.setTypeAccount("Ahorro");
        accountMock.setInitBalance(1000);
        accountMock.setStatus(true);

        accountListMock = new ArrayList<>();
        accountListMock.add(accountMock);

    }

    @Test
    void shouldFindAccountById() {
        when(accountRepository.getById(1L)).thenReturn(accountMock);
        assertEquals("123",  domainService.findAccountById(1L).getNroAccount());
    }

    @Test
    void shouldSaveAccount() {
        when(accountRepository.save(accountMock)).thenReturn(accountMock);
        assertEquals("123",  domainService.saveAccount(accountMock).getNroAccount());
    }

    @Test
    void shouldFetchAccountList() {
        when(accountRepository.getAll()).thenReturn(accountListMock);
        assertNotNull(domainService.fetchAccountList());
    }

    @Test
    void shouldUpdateAccount() {
        when(accountRepository.getById(1L)).thenReturn(accountMock);
        when(accountRepository.save(accountMock)).thenReturn(accountMock);
        assertEquals("123",  domainService.updateAccount(accountMock, 1L).getNroAccount());
    }

    @Test
    void shouldUpdateAccountNull() {
        when(accountRepository.getById(1L)).thenReturn(null);
        when(accountRepository.save(accountMock)).thenReturn(accountMock);
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            domainService.updateAccount(accountMock, 1L).getNroAccount();
        });

    }

    @Test
    void shouldDeleteAccountById() {

        domainService.deleteAccountById(1L);
        verify(accountRepository).deleteById(1L);
    }

    @Test
    void shouldFindAccountByNroCuenta() {
        when(accountRepository.findAccountByNroCuenta("123")).thenReturn(accountMock);
        assertEquals("123",  domainService.findAccountByNroCuenta("123").getNroAccount());
    }

}
