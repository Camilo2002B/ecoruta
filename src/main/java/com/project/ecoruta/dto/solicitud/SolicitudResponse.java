package com.project.ecoruta.dto.solicitud;

import com.project.ecoruta.model.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudResponse {

  private Long id;

  private UsuarioEntity usuario;

  private LocalDate fechaSolicitud;

  private LocalTime horaSolicitud;

  private String residuos;

  private LocalDateTime fechaHoraCreacion;
}
