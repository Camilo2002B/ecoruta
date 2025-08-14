package com.project.ecoruta.controller;

import com.project.ecoruta.dto.LoginRQ;
import com.project.ecoruta.dto.UsuarioResponse;
import com.project.ecoruta.dto.UsuarioRQ;
import com.project.ecoruta.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

  private final UsuarioService usuarioService;

  @PostMapping("/registro")
  public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioRQ usuario) {
    UsuarioResponse nuevoUsuario = usuarioService.registrarUsuario(usuario);
    return ResponseEntity.ok(nuevoUsuario);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRQ loginRQ) {
    UsuarioResponse usuario = usuarioService.login(loginRQ);
    if (usuario != null) {
      return ResponseEntity.ok(usuario);
    } else {
      return ResponseEntity.status(401).body("Credenciales inválidas");
    }
  }
}
