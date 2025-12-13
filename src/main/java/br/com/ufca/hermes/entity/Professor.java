package br.com.ufca.hermes.entity;

public class Professor extends Funcionario {

    private int idProfessor;
    private int idDisciplina;

    public Professor(
            int idUsuario,
            String nome,
            String email,
            String senha,
            String telefone,
            String categoria,
            int idFuncionario,
            String cargo,
            int idProfessor,
            int idDisciplina
    ) {
        super(idUsuario, nome, email, senha, telefone, categoria, idFuncionario, cargo);
        this.idProfessor = idProfessor;
        this.idDisciplina = idDisciplina;
    }

    // Getters e Setters
}
