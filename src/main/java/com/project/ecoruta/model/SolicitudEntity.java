package com.project.ecoruta.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "usuario_id", nullable = false)
  private UsuarioEntity usuario;

  private LocalDate fechaSolicitud;

  private LocalTime horaSolicitud;

  private String residuos;

  private LocalDateTime fechaHoraCreacion;

  @PrePersist
  public void prePersist() {
    this.fechaHoraCreacion = LocalDateTime.now();
  }
}
