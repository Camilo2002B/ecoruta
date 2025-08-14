package com.project.ecoruta.mapper;

import com.project.ecoruta.dto.UsuarioResponse;
import com.project.ecoruta.dto.UsuarioRQ;
import com.project.ecoruta.model.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  UsuarioResponse toUsuarioResponse(UsuarioEntity entity);

  UsuarioEntity toEntity(UsuarioRQ usuarioRQ);
}
