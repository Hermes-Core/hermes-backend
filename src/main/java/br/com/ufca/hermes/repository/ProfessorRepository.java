package br.com.ufca.hermes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufca.hermes.Entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    // TODO: Adicionar métodos de busca quando o relacionamento com Disciplina for implementado
    // List<Professor> findByDisciplinasId(Long idDisciplina);
}
