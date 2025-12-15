package br.com.ufca.hermes.repository;

import br.com.ufca.hermes.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    /**
     * Busca funcionários por cargo
     * @param cargo o cargo do funcionário
     * @return lista de funcionários com o cargo especificado
     */
    List<Funcionario> findByCargo(String cargo);
}
