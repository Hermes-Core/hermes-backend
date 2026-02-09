package br.com.ufca.hermes.repository;

import br.com.ufca.hermes.Entity.Aluno;
import br.com.ufca.hermes.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    /**
     * Busca um aluno pelo usuário associado
     * @param usuario o usuário associado ao aluno
     * @return Optional contendo o aluno se encontrado
     */
    Optional<Aluno> findByUsuario(Usuario usuario);
    
    /**
     * Busca alunos pelo nome (case insensitive)
     * @param nome o nome ou parte do nome do aluno
     * @return lista de alunos encontrados
     */
    List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
