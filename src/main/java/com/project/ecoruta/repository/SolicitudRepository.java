package com.project.ecoruta.repository;

import com.project.ecoruta.model.SolicitudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<SolicitudEntity, Long> {

  List<SolicitudEntity> findByUsuarioId(Long idUsuario);
}
