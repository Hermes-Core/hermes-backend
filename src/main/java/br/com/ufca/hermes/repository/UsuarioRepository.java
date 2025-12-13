package br.com.ufca.hermes.repository;

import br.com.ufca.hermes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    /**
     * Busca um usuário pelo email
     * @param email o email do usuário
     * @return Optional contendo o usuário se encontrado
     */
    Optional<Usuario> findByEmail(String email);
    
    /**
     * Verifica se existe um usuário com o email informado
     * @param email o email a ser verificado
     * @return true se existe, false caso contrário
     */
    boolean existsByEmail(String email);
}
