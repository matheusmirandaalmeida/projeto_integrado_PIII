package projeto_integrador.estacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto_integrador.estacionamento.dto.ReservaRequest;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.entity.Reserva;
import projeto_integrador.estacionamento.entity.Vaga;
import projeto_integrador.estacionamento.repository.ClienteRepository;
import projeto_integrador.estacionamento.repository.ReservaRepository;
import projeto_integrador.estacionamento.repository.VagaRepository;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final VagaRepository vagaRepository;
    private final ClienteRepository clienteRepository;
}
