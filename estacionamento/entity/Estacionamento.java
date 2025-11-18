package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estacionamento")
@Getter
@Setter
@NoArgsConstructor
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamento") // É bom nomear a coluna de ID
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "cnpj", nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Column(name = "horario_funcionamento")
    private String horarioFuncionamento;

    @Column(name = "tarifa")
    private Double tarifa;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL)
    private List<Vaga> vagas;
}