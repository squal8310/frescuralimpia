package com.bytesolutions.app.frescura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytesolutions.app.frescura.model.Producto;
import com.bytesolutions.app.frescura.repository.ProductoRepository;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public String ventas(@RequestParam(required = false) String filtro, Model model) {
        List<Producto> productos;
        
        if (filtro != null && !filtro.trim().isEmpty()) {
            productos = productoRepository.findByNombreContainingIgnoreCase(filtro);
        } else {
            productos = productoRepository.findAll();
        }
        
        model.addAttribute("productos", productos);
        model.addAttribute("filtro", filtro != null ? filtro : "");
        
        return "ventas";
    }
} 