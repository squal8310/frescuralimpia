package com.bytesolutions.app.frescura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytesolutions.app.frescura.model.Producto;
import com.bytesolutions.app.frescura.model.Categoria;
import com.bytesolutions.app.frescura.repository.ProductoRepository;
import com.bytesolutions.app.frescura.repository.CategoriaRepository;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String ventas(
            @RequestParam(required = false) String filtro,
            @RequestParam(required = false) Integer categoriaId,
            Model model) {
        
        List<Producto> productos;
        
        // Obtener todas las categorías para el selector
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        
        // Filtrar por nombre y/o categoría
        if (filtro != null && !filtro.trim().isEmpty() && categoriaId != null) {
            // Filtrar por ambos
            productos = productoRepository.findByNombreContainingIgnoreCaseAndCategoria(filtro, categoriaId);
        } else if (filtro != null && !filtro.trim().isEmpty()) {
            // Filtrar solo por nombre
            productos = productoRepository.findByNombreContainingIgnoreCase(filtro);
        } else if (categoriaId != null) {
            // Filtrar solo por categoría
            productos = productoRepository.findByCategoria(categoriaId);
        } else {
            // Sin filtros
            productos = productoRepository.findAll();
        }
        
        model.addAttribute("productos", productos);
        model.addAttribute("filtro", filtro != null ? filtro : "");
        model.addAttribute("categoriaId", categoriaId);
        
        return "ventas";
    }
} 