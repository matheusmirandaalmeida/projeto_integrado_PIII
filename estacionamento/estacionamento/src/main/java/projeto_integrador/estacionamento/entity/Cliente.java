package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false)
    private String nome;

    //armazenar CPF (11) ou CNPJ (14)
    @Column(nullable = false, unique = true, length = 18)
    private String cpfCnpj;

    @Column(nullable = false, unique = true, length = 15)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}
