package br.com.ufca.hermes.entity;

public class Funcionario extends Usuario {

    private int idFuncionario;
    private String cargo;

    public Funcionario(
            int idUsuario,
            String nome,
            String email,
            String senha,
            String telefone,
            String categoria,
            int idFuncionario,
            String cargo
    ) {
        super(idUsuario, nome, email, senha, telefone, categoria);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
    }

}


