package com.inventario.prestamos.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventario.prestamos.model.entity.Aliado;

@Repository
public interface AliadoDAOIface extends JpaRepository<Aliado, Long> {
    
}
