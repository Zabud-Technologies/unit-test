package com.zabud.factura.infraestructure.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="productos")
public class Producto {

  @Id
  private String codigo;
  private String nombre;
  private double valor;

}
