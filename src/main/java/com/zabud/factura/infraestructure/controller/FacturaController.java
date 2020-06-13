package com.zabud.factura.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zabud.factura.infraestructure.command.calcularfactura.CalcularFactura;
import com.zabud.factura.infraestructure.command.calcularfactura.Item;
import com.zabud.factura.infraestructure.repository.ProductoRepository;

@RestController
@RequestMapping("/factura")
public class FacturaController {

  @Autowired
  private ProductoRepository repository;


  @PostMapping("/calcular")
  public CalcularFactura calcular(@RequestBody CalcularFactura calcularFactura) {
    Double valorFactura = calcularFactura.getItems().stream().map(this::calcularValor).reduce(0D, (a, b) -> a + b);
    calcularFactura.setValor(valorFactura);
    return calcularFactura;
  }

  private double calcularValor(Item item) {
    double valorItem = item.getCantidad() * repository.findById(item.getProducto().getCodigo())
        .orElseThrow(() -> new RuntimeException("PRODUCTO_NO_DISPONIBLE")).getValor();
    item.setValor(valorItem);
    return valorItem;
  }


}
