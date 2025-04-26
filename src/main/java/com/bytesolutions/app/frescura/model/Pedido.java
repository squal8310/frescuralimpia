package com.bytesolutions.app.frescura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Double total;
    
    private LocalDate fecha;
    
    @Column(name = "id_cliente", nullable = false)
    private Integer idCliente;
    
    @Column(name = "id_comercial", nullable = false)
    private Integer idComercial;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_comercial", insertable = false, updatable = false)
    private Comercial comercial;
} 