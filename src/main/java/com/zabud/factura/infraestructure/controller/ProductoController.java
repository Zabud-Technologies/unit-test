package com.zabud.factura.infraestructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zabud.factura.infraestructure.command.ActualizarProducto;
import com.zabud.factura.infraestructure.command.CrearProducto;
import com.zabud.factura.infraestructure.dto.Producto;
import com.zabud.factura.infraestructure.repository.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {

  @Autowired
  ProductoRepository  repository;
  
  @GetMapping
  public List<Producto> getProductos(){
    return repository.findAll();
  }
  
  @PostMapping
  public void crear(@RequestBody CrearProducto crearProducto) {
    Producto producto = new Producto();
    producto.setCodigo(crearProducto.getCodigo());
    producto.setNombre(crearProducto.getNombre());
    producto.setValor(crearProducto.getValor());
    repository.save(producto);
  }
  
  @PutMapping("/{codigo}")
  public void actualizar(@PathVariable String codigo, @RequestBody ActualizarProducto actualizarProducto) {
    Producto producto = repository.findById(codigo).orElseThrow( ()-> new RuntimeException("PRODUCTO_NO_DISPONIBLE"));
    producto.setNombre(actualizarProducto.getNombre());
    producto.setValor(actualizarProducto.getValor());
    repository.save(producto);
  }
  
  @DeleteMapping("/{codigo}")
  public void eliminar(@PathVariable String codigo) {
    repository.findById(codigo).orElseThrow( ()-> new RuntimeException("PRODUCTO_NO_DISPONIBLE"));
    repository.deleteById(codigo);
  }
  
}
