package br.com.ufca.hermes.service.impl;

import br.com.ufca.hermes.DTO.UsuarioRequestDTO;
import br.com.ufca.hermes.DTO.UsuarioResponseDTO;
import br.com.ufca.hermes.Entity.Usuario;
import br.com.ufca.hermes.repository.UsuarioRepository;
import br.com.ufca.hermes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO requestDTO) {
        // Verificar se email já existe
        if (usuarioRepository.existsByEmail(requestDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenha(requestDTO.getSenha()); // TODO: Criptografar senha
        usuario.setTelefone(requestDTO.getTelefone());
        usuario.setCategoria(requestDTO.getCategoria());
        
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
        return converterParaDTO(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
        
        // Verificar se o email mudou e se já existe
        if (!usuario.getEmail().equals(requestDTO.getEmail()) && 
            usuarioRepository.existsByEmail(requestDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        if (requestDTO.getSenha() != null && !requestDTO.getSenha().isEmpty()) {
            usuario.setSenha(requestDTO.getSenha()); // TODO: Criptografar senha
        }
        usuario.setTelefone(requestDTO.getTelefone());
        usuario.setCategoria(requestDTO.getCategoria());
        
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return converterParaDTO(usuarioAtualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com email: " + email));
        return converterParaDTO(usuario);
    }

    private UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getCategoria()
        );
    }
}
