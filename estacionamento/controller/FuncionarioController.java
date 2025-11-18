package projeto_integrador.estacionamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Funcionario;
import projeto_integrador.estacionamento.service.FuncionarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    // 🔹 Listar todos
    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 🔹 Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Funcionario funcionario = service.buscarPorId(id);
        return ResponseEntity.ok(funcionario);
    }

    // 🔹 Criar novo
    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        Funcionario novo = service.criar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // 🔹 Atualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        Funcionario atualizado = service.atualizar(id, funcionario);
        return ResponseEntity.ok(atualizado);
    }

    // 🔹 Deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("message", "Funcionário removido com sucesso!"));
    }
}
