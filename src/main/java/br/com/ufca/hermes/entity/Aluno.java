package br.com.ufca.hermes.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long idAluno;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @ManyToOne 
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne 
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @OneToMany(mappedBy = "aluno")
    private List<Frequencia> frequencias;

    @ManyToOne 
    @JoinColumn(name = "id_frequencia")
    private Frequencia frequencia;

    @OneToMany(mappedBy = "aluno")
    private List<Atividade> atividades;

    @ManyToOne 
    @JoinColumn(name = "id_atividade")
    private Atividade atividade;
}
