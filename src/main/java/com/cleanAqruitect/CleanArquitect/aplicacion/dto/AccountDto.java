package com.cleanAqruitect.CleanArquitect.aplicacion.dto;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Client;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;
    @NotNull
    private String nroAccount;
    private String typeAccount;
    @NotNull
    private float initBalance;
    private Boolean status;
    @NotNull
    private Client client;
    private List<Movement> movementList;
}
