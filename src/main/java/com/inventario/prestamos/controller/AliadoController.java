package com.inventario.prestamos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

import com.inventario.prestamos.model.entity.Aliado;
import com.inventario.prestamos.service.InventarioServiceIface;

@Controller
@RequestMapping("/inventario")
@SessionAttributes("aliado")
public class AliadoController {
    private final InventarioServiceIface inventarioService;

    public AliadoController(InventarioServiceIface inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/aliadoslistar")
    public String listarAliados(@RequestParam(value = "pag", defaultValue = "0") int pag, Model model) {
        List<Aliado> aliados = inventarioService.buscarAliadosTodos();
        model.addAttribute("titulo", "Listado de aliados");
        model.addAttribute("aliados", aliados);
        return "aliados/lista_aliados";
    }

}
