package com.zabud.factura.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zabud.factura.infraestructure.dto.Producto;

public interface ProductoRepository extends JpaRepository<Producto, String> {

}
