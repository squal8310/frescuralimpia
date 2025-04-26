package com.bytesolutions.app.frescura.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "DTO para crear una nueva estrella")
public class StarRequest {
    
    @Schema(description = "Nombre de la estrella", example = "Estrella Oro")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 60, message = "El nombre no puede exceder los 60 caracteres")
    private String name;
} 