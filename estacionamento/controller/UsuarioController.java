package projeto_integrador.estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.service.UsuarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // 🟢 GET /usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 🔵 GET /usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // 🟣 POST /usuarios
    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Map<String, Object> dados) {
        Long idFuncionario = Long.valueOf(dados.get("idFuncionario").toString());
        Usuario novo = Usuario.builder()
                .login(dados.get("username").toString())
                .senhaHash(dados.get("senha").toString())
                .perfil(dados.get("role").toString())
                .build();
        return ResponseEntity.ok(service.criar(novo, idFuncionario));
    }

    // 🟠 PUT /usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.atualizar(id, usuario));
    }

    // 🔴 DELETE /usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
