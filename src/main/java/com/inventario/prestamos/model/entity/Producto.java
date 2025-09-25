package com.inventario.prestamos.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.EAN;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String descripcion;
    private Integer cantidad;
    private Date fechaUltIngreso;
	private boolean disponible;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String nombreUsuario;
    private String responsable;
    private String categoria;

    public Producto(Long id, String descripcion, Integer cantidad, Date fechaUltIngreso, boolean disponible,
            Date fechaPrestamo, Date fechaDevolucion, String nombreUsuario, String responsable, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaUltIngreso = fechaUltIngreso;
        this.disponible = disponible;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.nombreUsuario = nombreUsuario;
        this.responsable = responsable;
        this.categoria = categoria;
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaUltIngreso() {
        return fechaUltIngreso;
    }

    public void setFechaUltIngreso(Date fechaUltIngreso) {
        this.fechaUltIngreso = fechaUltIngreso;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", fechaUltIngreso="
                + fechaUltIngreso + ", disponible=" + disponible + ", fechaPrestamo=" + fechaPrestamo
                + ", fechaDevolucion=" + fechaDevolucion + ", nombreUsuario=" + nombreUsuario + ", responsable="
                + responsable + ", categoria=" + categoria + "]";
    }

}
