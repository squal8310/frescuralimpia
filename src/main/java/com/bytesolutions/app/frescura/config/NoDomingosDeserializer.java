package com.bytesolutions.app.frescura.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class NoDomingosDeserializer extends JsonDeserializer<LocalDate> {
    
    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        LocalDate date = LocalDate.parse(p.getText());
        
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new IllegalArgumentException("No se permiten fechas en domingo");
        }
        
        return date;
    }
} 