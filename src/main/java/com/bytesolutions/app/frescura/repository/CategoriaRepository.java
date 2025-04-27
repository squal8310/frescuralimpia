package com.bytesolutions.app.frescura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytesolutions.app.frescura.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Métodos básicos proporcionados por JpaRepository
} 