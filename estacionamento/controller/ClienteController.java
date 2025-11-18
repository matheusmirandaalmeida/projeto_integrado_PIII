package projeto_integrador.estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.service.ClienteService;

import java.util.List;
//responde as requisições HTTP
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // insere automaticamente uma instancia
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }
    //ta respondendo as requisições e retorna a lista
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
    // faz a busca pelo id e retorna o cliente
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
    //Cadastra um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente novo = service.criar(cliente);
        return ResponseEntity.ok(novo);
    }
    // atualiza um cliente salvo no banco
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return ResponseEntity.ok(service.atualizar(id, clienteAtualizado));
    }
    // exclui
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
