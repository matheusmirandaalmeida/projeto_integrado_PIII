package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long idFuncionario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private Boolean ativo = true;

    //Relacionamento 1:1 com USUARIO (login/senha)
    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Usuario usuario;
}
