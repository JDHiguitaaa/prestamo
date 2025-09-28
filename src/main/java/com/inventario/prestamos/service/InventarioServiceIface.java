package com.inventario.prestamos.service;

import java.util.List;

import com.inventario.prestamos.model.entity.Aliado;
import com.inventario.prestamos.model.entity.Producto;

public interface InventarioServiceIface {

    // servicios para Producto
    public List<Producto> buscarProductosTodos();
    public void guardarProducto(Producto producto);
    public Producto buscarProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);

    // servicios para Aliado
    public List<Aliado> buscarAliadosTodos();
    public void guardarAliado(Aliado aliado);
    public Aliado buscarAliadoPorId(Long id);
    public void eliminarAliadoPorId(Long id);

}