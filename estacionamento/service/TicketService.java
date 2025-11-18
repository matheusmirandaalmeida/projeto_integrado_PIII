package projeto_integrador.estacionamento.service;

import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.entity.Ticket;
import projeto_integrador.estacionamento.repository.EstacionamentoRepository;
import projeto_integrador.estacionamento.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EstacionamentoRepository estacionamentoRepository;

    public TicketService(TicketRepository ticketRepository, EstacionamentoRepository estacionamentoRepository) {
        this.ticketRepository = ticketRepository;
        this.estacionamentoRepository = estacionamentoRepository;
    }


    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }


    public Ticket buscarPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
    }


    public Ticket criar(Long idEstacionamento, String placaVeiculo) {
        Estacionamento estacionamento = estacionamentoRepository.findById(idEstacionamento)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        Ticket ticket = new Ticket();
        ticket.setEstacionamento(estacionamento);
        ticket.setPlacaVeiculo(placaVeiculo);
        ticket.setDataEntrada(LocalDateTime.now());
        ticket.setValorTotal(0.0);

        return ticketRepository.save(ticket);
    }


    public Ticket registrarSaida(Long id) {
        Ticket ticket = buscarPorId(id);
        ticket.setDataSaida(LocalDateTime.now());
        ticket.calcularValor(ticket.getEstacionamento().getTarifa());
        return ticketRepository.save(ticket);
    }


    public void deletar(Long id) {
        Ticket ticket = buscarPorId(id);
        ticketRepository.delete(ticket);
    }
}
