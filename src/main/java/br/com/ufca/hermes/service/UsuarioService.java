package br.com.ufca.hermes.service;

import br.com.ufca.hermes.DTO.UsuarioRequestDTO;
import br.com.ufca.hermes.DTO.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    
    UsuarioResponseDTO criar(UsuarioRequestDTO requestDTO);
    
    List<UsuarioResponseDTO> listarTodos();
    
    UsuarioResponseDTO buscarPorId(Long id);
    
    UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO);
    
    void deletar(Long id);
    
    UsuarioResponseDTO buscarPorEmail(String email);
}
