package com.cleanAqruitect.CleanArquitect.infraestructura.controlador;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.AccountService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cuentas")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{idAccount}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable Long idAccount){
        AccountDto accountDto = accountService.findAccountById(idAccount);
        return   ResponseEntity.status(HttpStatus.OK).body(accountDto);
    }

    @GetMapping("/findByNro/{nroAccount}")
    public ResponseEntity<AccountDto> findAccountByNroAccount(@PathVariable String nroAccount){
        AccountDto accountDto = accountService.findAccountByNroAccount(nroAccount);
        return   ResponseEntity.status(HttpStatus.OK).body(accountDto);
    }

    @GetMapping("/")
    public List<AccountDto> findAccount(){
        List<AccountDto> accountDto = accountService.fetchAccountList();
        return accountDto;

    }
    @PostMapping("/")
    public ResponseEntity<AccountDto> saveAccount(@Valid @RequestBody AccountDto accountDto){
        AccountDto accountDto1 = accountService.saveAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDto1);

    }

    @PutMapping("/{idAccount}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long idAccount, @RequestBody AccountDto accountDto){
        AccountDto accountDto1 = accountService.updateAccount(accountDto, idAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountDto1);

    }

    @DeleteMapping ("/{idAccount}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long idAccount){
        accountService.deleteAccountById(idAccount);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado Correctamente: " + idAccount.toString() );


    }


}
