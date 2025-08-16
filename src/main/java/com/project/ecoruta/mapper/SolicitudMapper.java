package com.project.ecoruta.mapper;

import com.project.ecoruta.dto.auth.UsuarioResponse;
import com.project.ecoruta.dto.solicitud.SolicitudRQ;
import com.project.ecoruta.dto.solicitud.SolicitudResponse;
import com.project.ecoruta.model.SolicitudEntity;
import com.project.ecoruta.model.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolicitudMapper {

  SolicitudEntity toEntity(SolicitudRQ solicitudRQ);

  SolicitudResponse toResponse(SolicitudEntity entity);
}
