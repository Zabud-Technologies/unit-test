package com.zabud.factura.infraestructure.command;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CrearProducto {

  @NotBlank(message = "Codigo es obligatorio")
  private String codigo;
  @NotBlank(message = "Nombre es obligatorio")
  private String nombre;
  @NotBlank(message = "Valor es obligatorio")
  private Double valor;

}
