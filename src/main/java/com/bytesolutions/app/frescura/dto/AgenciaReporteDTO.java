package com.bytesolutions.app.frescura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaReporteDTO {
    private String agencia;
    private String nombre;
    private Integer totalClientes;
    private Integer clientesCobrados;
    private Integer porcentajeClientes;
    private Long ventas;
    private BigDecimal debito;
    private BigDecimal cobrado;
    private Integer porcentajeCobrado;
    private String categoria;
} 