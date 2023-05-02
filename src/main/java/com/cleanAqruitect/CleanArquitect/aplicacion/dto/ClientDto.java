package com.cleanAqruitect.CleanArquitect.aplicacion.dto;

import com.cleanAqruitect.CleanArquitect.dominio.entidad.Account;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class ClientDto   {

    private Long id;
    private String password;
    private Boolean status;
    @NotNull
    private String nombre;
    private String genero;
    private Integer edad;
    @NotNull
    @Size(min= 1,max = 50)
    private String identificacion;
    private String direccion;
    private String telefono;
    private List<Account> accountList;


}
