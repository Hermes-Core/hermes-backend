package br.com.ufca.hermes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("application", "Hermes - Sistema de Gestão Escolar");
        response.put("timestamp", LocalDateTime.now());
        response.put("message", "Aplicação funcionando corretamente!");
        
        return ResponseEntity.ok(response);
    }
}
