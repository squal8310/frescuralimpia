package com.bytesolutions.app.frescura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comercial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comercial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellido1;
    
    private String apellido2;
    
    private Float comision;
} 