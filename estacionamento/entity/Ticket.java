package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long idTicket;

    @ManyToOne
    @JoinColumn(name = "id_estacionamento", nullable = false)
    private Estacionamento estacionamento;

    @Column(name = "placa_veiculo", nullable = false)
    private String placaVeiculo;

    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "data_saida")
    private LocalDateTime dataSaida;

    @Column(name = "valor_total")
    private Double valorTotal;

    public void calcularValor(Double tarifaPorHora) {
        if (dataEntrada != null && dataSaida != null && tarifaPorHora != null) {
            long horas = java.time.Duration.between(dataEntrada, dataSaida).toHours();
            if (horas == 0) horas = 1; // mínimo 1 hora
            this.valorTotal = horas * tarifaPorHora;
        }
    }
}
