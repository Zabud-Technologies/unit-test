package com.zabud.factura.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.zabud.factura.infraestructure.command.calcularfactura.CalcularFactura;
import com.zabud.factura.infraestructure.command.calcularfactura.Item;
import com.zabud.factura.infraestructure.repository.ProductoRepository;
import lombok.val;
import com.zabud.factura.infraestructure.dto.Producto;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FacturaControllerTest {

  @Mock
  private ProductoRepository productoRepository;

  @InjectMocks
  private FacturaController facturaController;

  @BeforeEach
  void initUseCase() {
    Producto pt01 = new Producto();
    pt01.setCodigo("T01");
    pt01.setValor(50);
    Optional<Producto> retorno = Optional.ofNullable(pt01);
    when(productoRepository.findById("T01")).thenReturn(retorno);
  }

  @Test
  void calcular() {
    CalcularFactura response = facturaController.calcular(getCalcularFactura());
    assertTrue(response.getValor() == 100);
  }

  private CalcularFactura getCalcularFactura() {
    val calcularFactura = new CalcularFactura();
    calcularFactura.setItems(new ArrayList<>());
    calcularFactura.getItems().add(new Item());
    calcularFactura.getItems().get(0).setCantidad(2);
    calcularFactura.getItems().get(0).setProducto(new com.zabud.factura.infraestructure.command.calcularfactura.Producto());
    calcularFactura.getItems().get(0).getProducto().setCodigo("T01");
    return calcularFactura;
  }

}
