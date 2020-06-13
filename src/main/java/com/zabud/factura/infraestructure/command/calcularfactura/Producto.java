package com.zabud.factura.infraestructure.command.calcularfactura;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
  @NotBlank
  private String codigo;
}
