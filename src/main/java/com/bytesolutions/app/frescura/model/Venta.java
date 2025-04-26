package com.bytesolutions.app.frescura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    
    @Id
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    
    @Column(name = "FECHA_VENTA", nullable = false)
    private LocalDateTime fechaVenta;
    
    private Long transaccion;
    
    @Column(name = "PRODUCTO", nullable = false)
    private Integer producto;
    
    @Column(name = "CANTIDAD", nullable = false)
    private Double cantidad;
    
    @Column(name = "TOTAL", nullable = false)
    private Double total;
    
    private Double iva;
    
    private Integer cliente;
    
    @Column(name = "ESTADO", nullable = false)
    private Integer estado;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTO", insertable = false, updatable = false)
    private Producto productoEntity;
} 