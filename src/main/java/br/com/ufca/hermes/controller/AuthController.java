package br.com.ufca.hermes.controller;

import br.com.ufca.hermes.DTO.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        // TODO: Implementar autenticação real com JWT
        if ("admin@email.com".equals(request.getEmail()) &&
                "123456".equals(request.getSenha())) {

            return ResponseEntity.ok("Login realizado com sucesso");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Credenciais inválidas");
    }
}
