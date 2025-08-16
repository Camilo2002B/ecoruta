package com.project.ecoruta.service;

import com.project.ecoruta.dto.auth.LoginRQ;
import com.project.ecoruta.dto.auth.UsuarioResponse;
import com.project.ecoruta.dto.auth.UsuarioRQ;
import com.project.ecoruta.mapper.UsuarioMapper;
import com.project.ecoruta.model.RolesEntity;
import com.project.ecoruta.model.UsuarioEntity;
import com.project.ecoruta.repository.RolesRepository;
import com.project.ecoruta.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

  private final RolesRepository rolesRepository;

  private final PasswordEncoder passwordEncoder;

  private final UsuarioMapper mapper;

  public UsuarioResponse registrarUsuario(UsuarioRQ usuario) {
    RolesEntity rol = rolesRepository.findById(usuario.getRolId())
      .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
    usuario.setPuntosAcumulados(0);
    UsuarioEntity usuarioToSave = mapper.toEntity(usuario);
    usuarioToSave.setRol(rol);
    return mapper.toUsuarioResponse(usuarioRepository.save(usuarioToSave));
  }

  public UsuarioResponse login(LoginRQ loginRQ) {
    UsuarioEntity usuario = usuarioRepository.findByEmail(loginRQ.getEmail())
      .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (passwordEncoder.matches(loginRQ.getContrasena(), usuario.getContrasena())) {
      return mapper.toUsuarioResponse(usuario);
    } else {
      throw new RuntimeException("Contraseña incorrecta");
    }
  }
}
