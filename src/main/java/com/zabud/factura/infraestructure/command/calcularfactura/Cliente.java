package com.zabud.factura.infraestructure.command.calcularfactura;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
  @NotBlank
  private String nombre;
  private String direccion;
  
  
}
