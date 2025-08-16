package com.project.ecoruta.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRQ {

  private Long id;

  private String nombre;

  private String email;

  private String cedula;

  private String contrasena;

  private String telefono;

  private String localidad;

  private int puntosAcumulados;

  private Long rolId;
}
