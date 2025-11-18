package projeto_integrador.estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Ticket;
import projeto_integrador.estacionamento.service.TicketService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Ticket>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<Ticket> criar(@RequestBody Map<String, Object> dados) {
        Long idEstacionamento = Long.valueOf(dados.get("idEstacionamento").toString());
        String placaVeiculo = dados.get("placaVeiculo").toString();
        Ticket novo = service.criar(idEstacionamento, placaVeiculo);
        return ResponseEntity.ok(novo);
    }


    @PutMapping("/{id}/saida")
    public ResponseEntity<Ticket> registrarSaida(@PathVariable Long id) {
        Ticket atualizado = service.registrarSaida(id);
        return ResponseEntity.ok(atualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
