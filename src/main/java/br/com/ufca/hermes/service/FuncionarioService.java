package br.com.ufca.hermes.service;

import br.com.ufca.hermes.DTO.FuncionarioRequestDTO;
import br.com.ufca.hermes.DTO.FuncionarioResponseDTO;

import java.util.List;

public interface FuncionarioService {
    
    FuncionarioResponseDTO criar(FuncionarioRequestDTO requestDTO);
    
    List<FuncionarioResponseDTO> listarTodos();
    
    FuncionarioResponseDTO buscarPorId(Long id);
    
    FuncionarioResponseDTO atualizar(Long id, FuncionarioRequestDTO requestDTO);
    
    void deletar(Long id);
    
    List<FuncionarioResponseDTO> buscarPorCargo(String cargo);
    
    List<FuncionarioResponseDTO> listarSecretaria();
    
    List<FuncionarioResponseDTO> listarDirecao();
}
