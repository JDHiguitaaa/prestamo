package com.inventario.prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import java.util.List;
import com.inventario.prestamos.service.InventarioServiceIface;

import jakarta.validation.Valid;

import com.inventario.prestamos.model.entity.Producto;

@Controller
@RequestMapping("/inventario")
@SessionAttributes("producto")
public class ProductoController {
    private final InventarioServiceIface inventarioService;

    public ProductoController(InventarioServiceIface inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio/index";
    }



    @GetMapping("/productoslistar")
    public String listarProductos(@RequestParam(value = "pag", defaultValue = "0") int pag, Model model) {
        List<Producto> productos = inventarioService.buscarProductosTodos();
        model.addAttribute("titulo", "Listado de productos en inventario");
        model.addAttribute("productos", productos);
        return "productos/lista_productos";
    }

    @GetMapping("/productosagregar")
    public String productoAgregar(Model model) {
        model.addAttribute("titulo", "Agregar producto");
        model.addAttribute("producto", new Producto());
        return "productos/formulario_producto";
    }

    @PostMapping("/productoguardar")
    public String productoGuardar(@Valid @ModelAttribute Producto producto, BindingResult result,
            RedirectAttributes flash, Model model, SessionStatus status) {

        String accion = (producto.getId() == null) ? "agregado" : "modificado";

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo producto");
            model.addAttribute("accion", accion);
            model.addAttribute("info", "Complemente o corrija la información de los campos del formulario");
            return "productos/formulario_producto";
        }
        inventarioService.guardarProducto(producto);
        status.setComplete();
        flash.addFlashAttribute("success", "El producto ha sido " + accion + " con éxito");
        return "redirect:/inventario/productoslistar";
    }

    @GetMapping("/productoconsultar/{id}")
    public String productoConsultar(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Producto producto = inventarioService.buscarProductoPorId(id);
        if (producto == null) {
            flash.addFlashAttribute("warning", "El producto con ID " + id + " no existe");
            return "redirect:/inventario/productoslistar";
        }
        model.addAttribute("titulo", "Consulta de producto: " + producto.getDescripcion());
        model.addAttribute("producto", producto);
        return "productos/consulta_producto";
    }

    @GetMapping("/productoeliminar/{id}")
    public String productoEliminar(@PathVariable Long id, RedirectAttributes flash) {
        if (id > 0) {
            Producto producto = inventarioService.buscarProductoPorId(id);
            if (producto != null) {
                inventarioService.eliminarProductoPorId(id);
                flash.addFlashAttribute("success", "El producto " + id + " fue elimnado con exito");
            }
            else {
                flash.addFlashAttribute("warning", "El producto con ID " + id + " no está en la base de datos");
            }
        }
        else {
            flash.addFlashAttribute("error", "El ID del producto no puede ser negativo");
        }
        return "redirect:/inventario/productoslistar";
    }

    @GetMapping("/productomodificar/{id}")
    public String productoModificar(@PathVariable(value = "id") Long id, Model model) {
        Producto producto = null;
        if (id > 0) {
            producto = inventarioService.buscarProductoPorId(id);
            if (producto == null) {
                return "redirect:/inventario/productoslistar";
            }
        }
        model.addAttribute("accion", "Modificar");
        model.addAttribute("titulo", "Modificar producto");
        model.addAttribute("producto", producto);
        return "productos/formulario_producto";
    }
}
