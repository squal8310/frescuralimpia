package com.bytesolutions.app.frescura.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaExcelDTO {
    private String agencia;
    private String nombre;
    private Integer clientes;
    private Integer clientesCobrados;
    private Long venta;
    private BigDecimal debito;
    private BigDecimal cobrado;
} 