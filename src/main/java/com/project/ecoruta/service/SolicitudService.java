package com.project.ecoruta.service;

import com.project.ecoruta.dto.solicitud.SolicitudRQ;
import com.project.ecoruta.dto.solicitud.SolicitudResponse;
import com.project.ecoruta.mapper.SolicitudMapper;
import com.project.ecoruta.model.SolicitudEntity;
import com.project.ecoruta.model.UsuarioEntity;
import com.project.ecoruta.repository.SolicitudRepository;
import com.project.ecoruta.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SolicitudService {

  private final SolicitudRepository solicitudRepository;

  private final UsuarioRepository usuarioRepository;

  private final SolicitudMapper mapper;

  public SolicitudResponse registrarSolicitud(SolicitudRQ solicitudRQ) {
    UsuarioEntity usuario = usuarioRepository.findById(solicitudRQ.getUsuarioId())
      .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    SolicitudEntity solicitudTosave = mapper.toEntity(solicitudRQ);
    solicitudTosave.setUsuario(usuario);
    return mapper.toResponse(solicitudRepository.save(solicitudTosave));
  }

  public List<SolicitudResponse> getSolicitudesByUsuario(Long idUsuario) {
    return solicitudRepository.findByUsuarioId(idUsuario)
      .stream()
      .map(mapper::toResponse)
      .toList();
  }
}
