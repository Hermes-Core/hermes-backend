package br.com.ufca.hermes.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
/* import jakarta.persistence.OneToMany;
import java.util.List; */
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
/* import lombok.AllArgsConstructor;
import lombok.Getter; */
import lombok.NoArgsConstructor;
/* import lombok.Setter;
import jakarta.persistence.CascadeType; */

@Entity
@Table(name = "aluno")
@NoArgsConstructor

public class Aluno {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long idAluno;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_turma")
    private Long idTurma;

/*     @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Frequencia> frequencias; */

    // 🔗 1 Aluno -> N Atividades
/*     @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades; */
  
}
