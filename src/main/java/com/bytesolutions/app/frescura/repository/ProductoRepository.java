package com.bytesolutions.app.frescura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bytesolutions.app.frescura.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    
    @Query("SELECT p FROM Producto p WHERE p.categoria = :categoriaId")
    List<Producto> findByCategoria(@Param("categoriaId") Integer categoriaId);
    
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:nombre% AND p.categoria = :categoriaId")
    List<Producto> findByNombreContainingIgnoreCaseAndCategoria(@Param("nombre") String nombre, @Param("categoriaId") Integer categoriaId);
} 