package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String categoria;
    private String status;

    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private Estacionamento estacionamento;
}
