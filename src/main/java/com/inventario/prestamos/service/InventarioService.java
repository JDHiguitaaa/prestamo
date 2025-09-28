package com.inventario.prestamos.service;

import java.util.List;

import com.inventario.prestamos.model.dao.ProductoDAOIface;
import com.inventario.prestamos.model.dao.AliadoDAOIface;

import com.inventario.prestamos.model.entity.Aliado;
import com.inventario.prestamos.model.entity.Producto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventarioService implements InventarioServiceIface {
    private final ProductoDAOIface productoDAO;
    private final AliadoDAOIface aliadoDAO;

    public InventarioService(ProductoDAOIface productoDAO, AliadoDAOIface aliadoDAO) {
        this.productoDAO = productoDAO;
        this.aliadoDAO = aliadoDAO;
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

    // servicios para Aliado
    @Override
    @Transactional(readOnly = true)
    public List<Aliado> buscarAliadosTodos() {
        return aliadoDAO.findAll();
    }
    
    @Override
    @Transactional
    public void guardarAliado(Aliado aliado) {
        aliadoDAO.save(aliado);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Aliado buscarAliadoPorId(Long id) {
        return aliadoDAO.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public void eliminarAliadoPorId(Long id) {
        aliadoDAO.deleteById(id);
    }
}
