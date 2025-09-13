package com.inventario.prestamos.service;

import java.util.List;

import com.inventario.prestamos.model.dao.ProductoDAOIface;
import com.inventario.prestamos.model.entity.Producto;

import org.springframework.transaction.annotation.Transactional;

public class InventarioService implements InventarioServiceIface {
    private final ProductoDAOIface productoDAO;

    public InventarioService(ProductoDAOIface productoDAO) {
        this.productoDAO = productoDAO;
    }

    // servicios para Producto
    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarProductosTodos() {
        return productoDAO.findAll();
    }
    
    @Override
    @Transactional
    public void guardarProducto(Producto producto) {
        productoDAO.save(producto);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto buscarProductoPorId(Long id) {
        return productoDAO.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public void eliminarProductoPorId(Long id) {
        productoDAO.deleteById(id);
    }
}
