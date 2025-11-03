package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(nullable = false, name = "senha_hash")
    private String senhaHash;

    @Column(nullable = false, length = 20)
    private String perfil; // Exemplo: ADMIN, FUNCIONARIO

    @Column(name = "ultimo_acesso")
    private LocalDateTime ultimoAcesso;

    // 🔗 Relação 1:1 com FUNCIONARIO
    @OneToOne
    @JoinColumn(name = "funcionario_id", unique = true, nullable = false)
    private Funcionario funcionario;
}
