package com.inventario.prestamos.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestamos_productos")
public class PrestamoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Prestamo prestamo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public PrestamoProducto() {
    }

    public PrestamoProducto(Long id, Integer cantidad, Prestamo prestamo, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.prestamo = prestamo;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "PrestamoProducto [id=" + id + ", cantidad=" + cantidad + ", prestamoId=" + prestamo.getId()
                + ", productoId=" + producto.getId() + "]";
    }

}