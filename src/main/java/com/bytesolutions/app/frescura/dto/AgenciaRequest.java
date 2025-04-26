package com.bytesolutions.app.frescura.dto;

import com.bytesolutions.app.frescura.config.NoDomingosDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Schema(description = "DTO para crear una nueva agencia")
public class AgenciaRequest {
    
    @Schema(description = "Monto de deuda", example = "1000.00")
    @NotNull(message = "El monto de deuda no puede ser nulo")
    @DecimalMin(value = "0.00", message = "El monto de deuda debe ser mayor o igual a 0")
    private BigDecimal debit;

    @Schema(description = "Monto de cobranza", example = "500.00")
    @NotNull(message = "El monto de cobranza no puede ser nulo")
    @DecimalMin(value = "0.00", message = "El monto de cobranza debe ser mayor o igual a 0")
    private BigDecimal collection;

    @Schema(description = "Número de clientes", example = "10")
    @NotNull(message = "El número de clientes no puede ser nulo")
    @Min(value = 0, message = "El número de clientes debe ser mayor o igual a 0")
    private Integer clients;

    @Schema(description = "Ventas de la estrella", example = "1")
    @NotNull(message = "La estrella vende")
    private Long sells;

    @Schema(description = "ID de la estrella", example = "1")
    @NotNull(message = "La estrella no puede ser nula")
    private Long starId;

    @Schema(description = "Número de clientes cobrados", example = "5")
    @NotNull(message = "El número de clientes cobrados no puede ser nulo")
    @Min(value = 0, message = "El número de clientes cobrados debe ser mayor o igual a 0")
    private Integer clientsCollected;

    @Schema(description = "Fecha de registro (formato: YYYY-MM-DD, no se permiten domingos)", example = "2024-03-23")
    @NotNull(message = "La fecha de registro no puede ser nula")
    @JsonDeserialize(using = NoDomingosDeserializer.class)
    private LocalDate dateRegister;
} 