package br.com.ufca.hermes.controller;

import br.com.ufca.hermes.DTO.FuncionarioRequestDTO;
import br.com.ufca.hermes.DTO.FuncionarioResponseDTO;
import br.com.ufca.hermes.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    /**
     * POST /api/funcionarios - Criar novo funcionário (Secretaria ou Direção)
     */
    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> criar(@Valid @RequestBody FuncionarioRequestDTO requestDTO) {
        try {
            FuncionarioResponseDTO response = funcionarioService.criar(requestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * GET /api/funcionarios - Listar todos os funcionários
     */
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listarTodos() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    /**
     * GET /api/funcionarios/{id} - Buscar funcionário por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            FuncionarioResponseDTO response = funcionarioService.buscarPorId(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * PUT /api/funcionarios/{id} - Atualizar funcionário
     */
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody FuncionarioRequestDTO requestDTO) {
        try {
            FuncionarioResponseDTO response = funcionarioService.atualizar(id, requestDTO);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * DELETE /api/funcionarios/{id} - Deletar funcionário
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            funcionarioService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * GET /api/funcionarios/cargo/{cargo} - Buscar funcionários por cargo
     */
    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<FuncionarioResponseDTO>> buscarPorCargo(@PathVariable String cargo) {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.buscarPorCargo(cargo);
        return ResponseEntity.ok(funcionarios);
    }

    /**
     * GET /api/funcionarios/secretaria - Listar funcionários da Secretaria
     */
    @GetMapping("/secretaria")
    public ResponseEntity<List<FuncionarioResponseDTO>> listarSecretaria() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listarSecretaria();
        return ResponseEntity.ok(funcionarios);
    }

    /**
     * GET /api/funcionarios/direcao - Listar funcionários da Direção
     */
    @GetMapping("/direcao")
    public ResponseEntity<List<FuncionarioResponseDTO>> listarDirecao() {
        List<FuncionarioResponseDTO> funcionarios = funcionarioService.listarDirecao();
        return ResponseEntity.ok(funcionarios);
    }
}
