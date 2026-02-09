package br.com.ufca.hermes.repository;

import br.com.ufca.hermes.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    /**
     * Busca funcionários por cargo
     * @param cargo o cargo (SECRETARIA, DIRECAO)
     * @return lista de funcionários com o cargo especificado
     */
    List<Funcionario> findByCargo(String cargo);
    
    /**
     * Busca funcionário pela matrícula
     * @param matricula a matrícula do funcionário
     * @return lista de funcionários (deve ser único)
     */
    List<Funcionario> findByMatricula(String matricula);
    
    /**
     * Busca funcionários por departamento
     * @param departamento o departamento
     * @return lista de funcionários do departamento
     */
    List<Funcionario> findByDepartamento(String departamento);
    
    /**
     * Verifica se existe funcionário com a matrícula
     * @param matricula a matrícula a verificar
     * @return true se existe, false caso contrário
     */
    boolean existsByMatricula(String matricula);
}
