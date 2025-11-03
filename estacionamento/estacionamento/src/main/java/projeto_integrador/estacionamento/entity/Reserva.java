package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    // 🔗 CLIENTE que fez a reserva
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // 🔗 HORARIO associado (janela de tempo)
    @ManyToOne(optional = false)
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;

    // 🔗 VAGA específica reservada
    @ManyToOne(optional = false)
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false, length = 20)
    private String status; // PENDENTE, CONFIRMADA, CANCELADA, EXPIRADA

    @Column(name = "valor_previsto", precision = 10, scale = 2)
    private BigDecimal valorPrevisto;
}
