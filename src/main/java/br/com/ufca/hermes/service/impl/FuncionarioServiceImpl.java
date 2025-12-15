package br.com.ufca.hermes.service.impl;

import br.com.ufca.hermes.DTO.FuncionarioRequestDTO;
import br.com.ufca.hermes.DTO.FuncionarioResponseDTO;
import br.com.ufca.hermes.DTO.UsuarioResponseDTO;
import br.com.ufca.hermes.Entity.Funcionario;
import br.com.ufca.hermes.Entity.Usuario;
import br.com.ufca.hermes.repository.FuncionarioRepository;
import br.com.ufca.hermes.repository.UsuarioRepository;
import br.com.ufca.hermes.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public FuncionarioResponseDTO criar(FuncionarioRequestDTO requestDTO) {
        // Verificar se email já existe
        if (usuarioRepository.existsByEmail(requestDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        // Verificar se matrícula já existe
        if (requestDTO.getMatricula() != null && 
            funcionarioRepository.existsByMatricula(requestDTO.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }
        
        // Criar usuário
        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenha(requestDTO.getSenha()); // TODO: Criptografar senha
        usuario.setTelefone(requestDTO.getTelefone());
        usuario.setCategoria("FUNCIONARIO");
        
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        
        // Criar funcionário
        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(requestDTO.getCargo().toUpperCase());
        funcionario.setDepartamento(requestDTO.getDepartamento());
        funcionario.setMatricula(requestDTO.getMatricula());
        funcionario.setUsuario(usuarioSalvo);
        
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return converterParaDTO(funcionarioSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FuncionarioResponseDTO> listarTodos() {
        return funcionarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public FuncionarioResponseDTO buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
        return converterParaDTO(funcionario);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO atualizar(Long id, FuncionarioRequestDTO requestDTO) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
        
        Usuario usuario = funcionario.getUsuario();
        
        // Verificar se o email mudou e se já existe
        if (!usuario.getEmail().equals(requestDTO.getEmail()) && 
            usuarioRepository.existsByEmail(requestDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        
        // Verificar se a matrícula mudou e se já existe
        if (requestDTO.getMatricula() != null && 
            !requestDTO.getMatricula().equals(funcionario.getMatricula()) &&
            funcionarioRepository.existsByMatricula(requestDTO.getMatricula())) {
            throw new RuntimeException("Matrícula já cadastrada");
        }
        
        // Atualizar usuário
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        if (requestDTO.getSenha() != null && !requestDTO.getSenha().isEmpty()) {
            usuario.setSenha(requestDTO.getSenha()); // TODO: Criptografar senha
        }
        usuario.setTelefone(requestDTO.getTelefone());
        usuarioRepository.save(usuario);
        
        // Atualizar funcionário
        funcionario.setCargo(requestDTO.getCargo().toUpperCase());
        funcionario.setDepartamento(requestDTO.getDepartamento());
        funcionario.setMatricula(requestDTO.getMatricula());
        
        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return converterParaDTO(funcionarioAtualizado);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com ID: " + id));
        
        // Deletar funcionário e usuário associado
        Long usuarioId = funcionario.getUsuario().getId();
        funcionarioRepository.deleteById(id);
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FuncionarioResponseDTO> buscarPorCargo(String cargo) {
        return funcionarioRepository.findByCargo(cargo.toUpperCase()).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FuncionarioResponseDTO> listarSecretaria() {
        return buscarPorCargo("SECRETARIA");
    }

    @Override
    @Transactional(readOnly = true)
    public List<FuncionarioResponseDTO> listarDirecao() {
        return buscarPorCargo("DIRECAO");
    }

    private FuncionarioResponseDTO converterParaDTO(Funcionario funcionario) {
        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO(
                funcionario.getUsuario().getId(),
                funcionario.getUsuario().getNome(),
                funcionario.getUsuario().getEmail(),
                funcionario.getUsuario().getTelefone(),
                funcionario.getUsuario().getCategoria()
        );
        
        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getCargo(),
                funcionario.getDepartamento(),
                funcionario.getMatricula(),
                usuarioDTO
        );
    }
}
