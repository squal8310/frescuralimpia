package com.bytesolutions.app.frescura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private Double precioUnitario;
    
    @Column(name = "PRECIO_VENTA", nullable = false)
    private Double precioVenta;
    
    @Column(name = "FECHA_COMPRA", nullable = false)
    private LocalDateTime fechaCompra;
    
    @Column(nullable = false)
    private Integer categoria;
    
    @Column(nullable = false)
    private Boolean activo;
    
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
    
    @ManyToOne
    @JoinColumn(name = "categoria", insertable = false, updatable = false)
    private Categoria categoriaEntity;
} 