package br.com.ufca.hermes.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponseDTO {

    private Long id;
    private String cargo;
    private String departamento;
    private String matricula;
    private UsuarioResponseDTO usuario;
}
