package com.inventario.prestamos.service;

import java.util.List;
import com.inventario.prestamos.model.entity.Producto;

public interface InventarioServiceIface {

    // servicios para Producto
    public List<Producto> buscarProductosTodos();
    public void guardarProducto(Producto producto);
    public Producto buscarProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);

}