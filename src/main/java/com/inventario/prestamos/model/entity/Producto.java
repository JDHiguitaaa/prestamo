package com.inventario.prestamos.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    @NotEmpty
    private String descripcion;
    private Integer cantidad;

    @Column(name = "ultimo_ingreso")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull
	@Past
    private Date fechaUltIngreso;
    
	private boolean disponible;
    private String categoria;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrestamoProducto> prestamosProductos;

    public Producto() {
    }

    public Producto(Long id, String codigo, String descripcion, Integer cantidad, Date fechaUltIngreso, boolean disponible,
             String nombreUsuario, String categoria) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaUltIngreso = fechaUltIngreso;
        this.disponible = disponible;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<PrestamoProducto> getPrestamosProductos() {
        return prestamosProductos;
    }
    public void setPrestamosProductos(List<PrestamoProducto> prestamosProductos) {
        this.prestamosProductos = prestamosProductos;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad
                + ", fechaUltIngreso=" + fechaUltIngreso + ", disponible=" + disponible +", categoria=" + categoria + "]";
    }


}
