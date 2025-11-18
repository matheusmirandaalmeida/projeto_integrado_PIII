package projeto_integrador.estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.service.EstacionamentoService;

import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    private final EstacionamentoService service;

    public EstacionamentoController(EstacionamentoService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Estacionamento>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estacionamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<Estacionamento> criar(@RequestBody Estacionamento estacionamento) {
        Estacionamento novo = service.criar(estacionamento);
        return ResponseEntity.ok(novo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id, @RequestBody Estacionamento estacionamentoAtualizado) {
        return ResponseEntity.ok(service.atualizar(id, estacionamentoAtualizado));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
