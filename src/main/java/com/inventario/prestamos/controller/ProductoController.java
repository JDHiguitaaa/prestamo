package com.inventario.prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.util.List;
import com.inventario.prestamos.service.InventarioServiceIface;
import com.inventario.prestamos.model.entity.Producto;

@Controller
@RequestMapping("/inventario")
@SessionAttributes("producto")
public class ProductoController {
    private final InventarioServiceIface inventarioService;

    public ProductoController(InventarioServiceIface inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/productoslistar")
    public String listarProductos(@RequestParam(value = "pag", defaultValue = "0") int pag, Model model) {
        List<Producto> productos = inventarioService.buscarProductosTodos();
        model.addAttribute("titulo", "Listado de productos en inventario");
        model.addAttribute("productos", productos);
        return "productos/lista_productos";
    }
}
