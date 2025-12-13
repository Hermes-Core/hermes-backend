package com.exemplo.demo.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {


        if ("admin@email.com".equals(request.getEmail()) &&
                "123456".equals(request.getSenha())) {

            return ResponseEntity.ok("Login realizado com sucesso");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Credenciais inválidas");
    }
}
