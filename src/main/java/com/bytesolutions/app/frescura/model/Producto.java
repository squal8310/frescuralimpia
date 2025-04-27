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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", insertable = false, updatable = false)
    private Categoria categoriaEntity;
    
    // Getters y setters explícitos para asegurar que sean públicos
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public Double getPrecioVenta() {
        return precioVenta;
    }
    
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }
    
    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    public Integer getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }
    
    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public Categoria getCategoriaEntity() {
        return categoriaEntity;
    }
    
    public void setCategoriaEntity(Categoria categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }
} 