package com.cleanAqruitect.CleanArquitect.aplicacion.dto;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MovementDto {

    private Long id;
    private Date dateMov;
    @NotNull
    private String typeMove;
    @NotNull
    private float value;
    private float balance;
    @NotNull
    private Account account;
}
