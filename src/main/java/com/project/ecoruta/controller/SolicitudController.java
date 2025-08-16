package com.project.ecoruta.controller;

import com.project.ecoruta.dto.solicitud.SolicitudRQ;
import com.project.ecoruta.dto.solicitud.SolicitudResponse;
import com.project.ecoruta.service.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

  private final SolicitudService solicitudService;

  @PostMapping("/registro")
  public ResponseEntity<SolicitudResponse> registrar(@RequestBody SolicitudRQ solicitudRQ) {
    SolicitudResponse solicitudResponse = solicitudService.registrarSolicitud(solicitudRQ);
    return ResponseEntity.ok(solicitudResponse);
  }

  @GetMapping("/{idUsuario}")
  public ResponseEntity<List<SolicitudResponse>> getSolicitudesByUsuario(@PathVariable Long idUsuario) {
    List<SolicitudResponse> solicitudes = solicitudService.getSolicitudesByUsuario(idUsuario);
    return ResponseEntity.ok(solicitudes);
  }
}
