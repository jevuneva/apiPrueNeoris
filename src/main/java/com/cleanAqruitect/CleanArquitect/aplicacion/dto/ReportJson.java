package com.cleanAqruitect.CleanArquitect.aplicacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReportJson {

    private Date fecha;
    private String cliente;
    private String nroCuenta;
    private String tipo;
    private float saldoInicial;
    private boolean estado;
    private float movimiento;
    private float saldoDisponible;

}
