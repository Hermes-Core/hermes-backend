package br.com.ufca.hermes.repository;

import br.com.ufca.hermes.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    /**
     * Busca professores por disciplina
     * @param idDisciplina o ID da disciplina
     * @return lista de professores da disciplina
     */
    List<Professor> findByIdDisciplina(int idDisciplina);
}
