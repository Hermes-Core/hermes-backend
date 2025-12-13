import javax.persistence.*;
@Entity
@Table(name = "tb_usuario")
public class pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "E-mail é obrigatório")
    @Column(nullable = false)
    private String email;
    @NotBlank(message = "Senha é obrigatória")
    @Column(nullable = false)
    private String senha;
    private int telefone;


    public pessoa() {
    }



    public pessoa(Long id, String name, String email, String senha, int telefone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "pessoa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}