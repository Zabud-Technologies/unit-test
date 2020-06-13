package com.zabud.factura.infraestructure.command.calcularfactura;

import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcularFactura {
  @NotBlank
  private Cliente cliente;
  @NotBlank
  private List<Item> items;
  private Double valor;

}
