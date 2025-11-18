package projeto_integrador.estacionamento.service;

import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository  = repository;
    }
    // retorna os clientes cadastrados no banco
    public List<Cliente> listarTodos() {
        return repository.findAll();
    }
    //busca um cliente pelo id e caso nao encontrar retorna a mensagem de erro
    public Cliente buscarPorId(long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    //cria um novo cliente e salva no banco
    public Cliente criar(Cliente cliente){
        return repository.save(cliente);
    }
    // atualiza as informações de um cliente salvo no banco pelo ID
    public Cliente atualizar(Long id, Cliente clienteAtualizado){
        Cliente clienteExistente = buscarPorId(id);

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setCpfCnpj(clienteAtualizado.getCpfCnpj());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setDataCadastro(clienteAtualizado.getDataCadastro());

        return repository.save(clienteExistente);

    }
    // deleta o cliente do banco pelo ID
    public void deletar(Long id){
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }
}
