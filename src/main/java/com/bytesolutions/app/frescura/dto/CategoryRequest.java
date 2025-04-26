package com.bytesolutions.app.frescura.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "DTO para crear una nueva categoría")
public class CategoryRequest {
    
    @Schema(description = "Nombre de la categoría", example = "Categoría A")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 30, message = "El nombre no puede exceder los 30 caracteres")
    private String name;

    @Schema(description = "Porcentaje mínimo de la categoría", example = "90.00")
    @DecimalMin(value = "0.00", message = "El porcentaje mínimo debe ser mayor o igual a 0")
    @DecimalMax(value = "100.00", message = "El porcentaje mínimo debe ser menor o igual a 100")
    private BigDecimal percentageLow;

    @Schema(description = "Porcentaje máximo de la categoría", example = "95.00")
    @DecimalMin(value = "0.00", message = "El porcentaje máximo debe ser mayor o igual a 0")
    @DecimalMax(value = "100.00", message = "El porcentaje máximo debe ser menor o igual a 100")
    private BigDecimal percentageHigh;

    @Schema(description = "Valor mínimo de venta", example = "0.00")
    @DecimalMin(value = "0.00", message = "El valor mínimo debe ser mayor o igual a 0")
    private BigDecimal sellLow;

    @Schema(description = "Valor máximo de venta", example = "100.00")
    @DecimalMin(value = "0.00", message = "El valor máximo debe ser mayor o igual a 0")
    private BigDecimal sellHigh;
} 