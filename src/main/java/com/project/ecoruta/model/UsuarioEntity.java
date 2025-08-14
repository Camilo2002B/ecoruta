package com.project.ecoruta.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  private String email;

  private String cedula;

  private String contrasena;

  private String telefono;

  private String localidad;

  private int puntosAcumulados;

  @ManyToOne
  @JoinColumn(name = "rol_id", nullable = false)
  private RolesEntity rol;
}
